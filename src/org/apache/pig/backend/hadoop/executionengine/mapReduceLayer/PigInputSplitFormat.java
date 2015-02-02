/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.pig.backend.hadoop.executionengine.mapReduceLayer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.BlockLocation;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.InputFormat;
import org.apache.hadoop.mapreduce.InputSplit;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.JobContext;
import org.apache.hadoop.mapreduce.TaskAttemptContext;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.pig.CollectableLoadFunc;
import org.apache.pig.FuncSpec;
import org.apache.pig.IndexableLoadFunc;
import org.apache.pig.LoadFunc;
import org.apache.pig.OrderedLoadFunc;
import org.apache.pig.PigConfiguration;
import org.apache.pig.PigException;
import org.apache.pig.backend.executionengine.ExecException;
import org.apache.pig.backend.hadoop.datastorage.ConfigurationUtil;
import org.apache.pig.backend.hadoop.executionengine.shims.HadoopShims;
import org.apache.pig.backend.hadoop.executionengine.util.MapRedUtil;
import org.apache.pig.data.Tuple;
import org.apache.pig.impl.PigContext;
import org.apache.pig.impl.io.FileSpec;
import org.apache.pig.impl.plan.OperatorKey;
import org.apache.pig.impl.util.ObjectSerializer;
import org.apache.pig.impl.util.UDFContext;
import org.apache.pig.impl.util.Utils;

public class PigInputSplitFormat extends FileInputFormat<Text, Tuple> {

    public static final Log log = LogFactory.getLog(PigInputSplitFormat.class);

    public static final String PIG_INPUTS = "pig.inputs";

    /**
     * @deprecated Use {@link UDFContext} instead in the following way to get
     *             the job's {@link Configuration}:
     * 
     *             <pre>
     * UdfContext.getUdfContext().getJobConf()
     * </pre>
     */
    @Deprecated
    public static Configuration sJob;

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.apache.hadoop.mapreduce.InputFormat#createRecordReader(org.apache
     * .hadoop.mapreduce.InputSplit,
     * org.apache.hadoop.mapreduce.TaskAttemptContext)
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public org.apache.hadoop.mapreduce.RecordReader<Text, Tuple> createRecordReader(
            org.apache.hadoop.mapreduce.InputSplit split,
            TaskAttemptContext context) throws IOException,
            InterruptedException {
        // We need to create a TaskAttemptContext based on the Configuration
        // which
        // was used in the getSplits() to produce the split supplied here. For
        // this, let's find out the input of the script which produced the split
        // supplied here and then get the corresponding Configuration and setup
        // TaskAttemptContext based on it and then call the real InputFormat's
        // createRecordReader() method

        PigSplit pigSplit = (PigSplit) split;
        activeSplit = pigSplit;
        // XXX hadoop 20 new API integration: get around a hadoop 20 bug by
        // passing total # of splits to each split so it can be retrieved
        // here and set it to the configuration object. This number is needed
        // by PoissonSampleLoader to compute the number of samples
        int n = pigSplit.getTotalSplits();
        context.getConfiguration().setInt("pig.mapsplits.count", n);
        Configuration conf = context.getConfiguration();
        LoadFunc loadFunc = getLoadFunc(pigSplit.getInputIndex(), conf);
        // Pass loader signature to LoadFunc and to InputFormat through
        // the conf
        passLoadSignature(loadFunc, pigSplit.getInputIndex(), conf);

        // merge entries from split specific conf into the conf we got
        PigInputSplitFormat.mergeSplitSpecificConf(loadFunc, pigSplit, conf);

        // for backward compatibility
        PigInputSplitFormat.sJob = conf;

        InputFormat inputFormat = loadFunc.getInputFormat();

        List<Long> inpLimitLists = (ArrayList<Long>) ObjectSerializer
                .deserialize(conf.get("pig.inpLimits"));

        return new PigRecordReader(inputFormat, pigSplit, loadFunc, context,
                inpLimitLists.get(pigSplit.getInputIndex()));
    }

    /**
     * get the corresponding configuration for the input on which the split is
     * based and merge it with the Conf supplied
     * 
     * package level access so that this is not publicly used elsewhere
     * 
     * @throws IOException
     */
    static void mergeSplitSpecificConf(LoadFunc loadFunc, PigSplit pigSplit,
            Configuration originalConf) throws IOException {
        // set up conf with entries from input specific conf
        Job job = new Job(originalConf);
        loadFunc.setLocation(getLoadLocation(pigSplit.getInputIndex(),
                originalConf), job);
        // The above setLocation call could write to the conf within
        // the job - merge that updated conf with original conf
        ConfigurationUtil.mergeConf(originalConf, job.getConfiguration());

    }

    /**
     * @param inputIndex
     * @param conf
     * @return
     * @throws IOException
     */
    @SuppressWarnings("unchecked")
    private static LoadFunc getLoadFunc(int inputIndex, Configuration conf)
            throws IOException {
        ArrayList<FileSpec> inputs = (ArrayList<FileSpec>) ObjectSerializer
                .deserialize(conf.get(PIG_INPUTS));
        FuncSpec loadFuncSpec = inputs.get(inputIndex).getFuncSpec();
        return (LoadFunc) PigContext.instantiateFuncFromSpec(loadFuncSpec);
    }

    @SuppressWarnings("unchecked")
    private static String getLoadLocation(int inputIndex, Configuration conf)
            throws IOException {
        ArrayList<FileSpec> inputs = (ArrayList<FileSpec>) ObjectSerializer
                .deserialize(conf.get(PIG_INPUTS));
        return inputs.get(inputIndex).getFileName();
    }

    /**
     * Pass loader signature to LoadFunc and to InputFormat through the conf
     * 
     * @param loadFunc
     *            the Loadfunc to set the signature on
     * @param inputIndex
     *            the index of the input corresponding to the loadfunc
     * @param conf
     *            the Configuration object into which the signature should be
     *            set
     * @throws IOException
     *             on failure
     */
    @SuppressWarnings("unchecked")
    static void passLoadSignature(LoadFunc loadFunc, int inputIndex,
            Configuration conf) throws IOException {
        List<String> inpSignatureLists = (ArrayList<String>) ObjectSerializer
                .deserialize(conf.get("pig.inpSignatures"));
        // signature can be null for intermediate jobs where it will not
        // be required to be passed down
        if (inpSignatureLists.get(inputIndex) != null) {
            loadFunc.setUDFContextSignature(inpSignatureLists.get(inputIndex));
            conf.set("pig.loader.signature", inpSignatureLists.get(inputIndex));
        }

        MapRedUtil.setupUDFContext(conf);
    }

    private static final double SPLIT_SLOP = 1.1;

    protected Random random = new Random();

    protected void addSplit(List<InputSplit> splits, FileSplit inputSplit) {
        // if (random.nextInt(limr) <= threshold) {
        splits.add(inputSplit);
        // }
    }

    /**
     * This function returns the sample split due to the chunksize
     * and the rate.
     * @param job
     * @return
     * @throws IOException
     */
    public List<InputSplit> getSplitsSample(JobContext job) throws IOException {
        long minSize = Math.max(getFormatMinSplitSize(), getMinSplitSize(job));
        long maxSize = getMaxSplitSize(job);
        float rate = job.getConfiguration().getFloat(PigConfiguration.PIG_H2IRG_ROLLUP_RATE, 0);
        double maximumSamplingSize = 0;
        String inputFile = job.getConfiguration().get("pig.input.dirs", "");
        if(inputFile!="") {
            Path pPivot = new Path(inputFile);
            FileSystem fs = FileSystem.get(job.getConfiguration());
            FileStatus stt = fs.getFileStatus(pPivot);
            long fileLength = stt.getLen();
            maximumSamplingSize = fileLength*rate;
        }
       
        ArrayList<ArrayList<InputSplit>> splitArray = null;
        
        int noOfSizes = 0;
        String splitSizes[] = null;
        long preVariableSizes[] = null;
        String variableSplit = job.getConfiguration().get("pig.h2irg.rollup.variablesplit", "");
        if(variableSplit.equals("")) {
            noOfSizes = 4;
            preVariableSizes = new long[4];
            preVariableSizes[0] = 256;
            preVariableSizes[1] = 512;
            preVariableSizes[2] = 1024;
            preVariableSizes[3] = 2048;
        } else {
            splitSizes = variableSplit.split(",");
            noOfSizes = splitSizes.length;
            preVariableSizes = new long[noOfSizes];
            for(int i = 0; i < noOfSizes; i++) {
                preVariableSizes[i] = Long.parseLong(splitSizes[i]);
            }
        }
        
        long postVariableSizes[] = new long[noOfSizes];
        long oneKB = 1024;
        for(int i = 0; i < noOfSizes; i++) {
            postVariableSizes[i] = preVariableSizes[i]*oneKB;
        }
        

        splitArray = new ArrayList<ArrayList<InputSplit>>();
        for (int i = 0; i < noOfSizes + 1; i++) {
            ArrayList<InputSplit> single = new ArrayList<InputSplit>();
            splitArray.add(single);
        }
        
        for (FileStatus file : listStatus(job)) {
            Path path = file.getPath();
            FileSystem fs = path.getFileSystem(job.getConfiguration());
            long length = file.getLen();
            BlockLocation[] blkLocations = fs.getFileBlockLocations(file, 0,
                    length);
            if ((length != 0) && isSplitable(job, path)) {
                long bytesRemaining = length;
                long totalBytes = 0;
                int count = noOfSizes;
                for (int i = 0; i < noOfSizes; i++) {
                    while (totalBytes < length/noOfSizes) {
                        int blkIndex = getBlockIndex(blkLocations, length
                                - bytesRemaining);
                        addSplit(splitArray.get(i), new FileSplit(path, length
                                - bytesRemaining, postVariableSizes[i], blkLocations[blkIndex]
                                .getHosts()));
                        bytesRemaining -= postVariableSizes[i];
                        totalBytes +=postVariableSizes[i];
                    }
                    count--;
                    bytesRemaining = count*(length/noOfSizes);
                    totalBytes = 0;
                }

                if (bytesRemaining != 0) {
                    addSplit(splitArray.get(splitArray.size() - 1), new FileSplit(path, length
                            - bytesRemaining, bytesRemaining,
                            blkLocations[blkLocations.length - 1].getHosts()));
                }
            } else if (length != 0) {
                addSplit(splitArray.get(splitArray.size() - 1), new FileSplit(path, 0, length, blkLocations[0]
                        .getHosts()));
            } else {
                addSplit(splitArray.get(splitArray.size() - 1), new FileSplit(path, 0, length, new String[0]));
            }
        }
        
        for(int i = 0; i < noOfSizes; i++) {
            log.info("Total # of " + postVariableSizes[i] + " splits: " + splitArray.get(i).size());
            Collections.shuffle(splitArray.get(i));
        }

        List<InputSplit> splitsReturn = new ArrayList<InputSplit>();
        
        for (int i = 0; i < noOfSizes; i++) {
            int noSampleSplit = (int) Math.ceil(rate*splitArray.get(i).size());
            if(noSampleSplit == 0)
                noSampleSplit = 1;
            for(int j = 0; j < noSampleSplit; j++) {
                splitsReturn.add(splitArray.get(i).get(j));
            }
        }
        
        log.info("Total # of sampling splits: " + splitsReturn.size());
        
        return splitsReturn;
    }
    /*
     * (non-Javadoc)
     * 
     * @see
     * org.apache.hadoop.mapreduce.InputFormat#getSplits(org.apache.hadoop.mapreduce
     * .JobContext)
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public List<InputSplit> getSplits(JobContext jobcontext) throws IOException {

        Configuration conf = jobcontext.getConfiguration();

        ArrayList<FileSpec> inputs;
        ArrayList<ArrayList<OperatorKey>> inpTargets;
        PigContext pigContext;
        try {
            inputs = (ArrayList<FileSpec>) ObjectSerializer.deserialize(conf
                    .get("pig.inputs"));
            inpTargets = (ArrayList<ArrayList<OperatorKey>>) ObjectSerializer
                    .deserialize(conf.get("pig.inpTargets"));
            pigContext = (PigContext) ObjectSerializer.deserialize(conf
                    .get("pig.pigContext"));
            PigContext
                    .setPackageImportList((ArrayList<String>) ObjectSerializer
                            .deserialize(conf.get("udf.import.list")));
            MapRedUtil.setupUDFContext(conf);
        } catch (Exception e) {
            int errCode = 2094;
            String msg = "Unable to deserialize object.";
            throw new ExecException(msg, errCode, PigException.BUG, e);
        }

        ArrayList<InputSplit> splits = new ArrayList<InputSplit>();
        for (int i = 0; i < inputs.size(); i++) {
            try {
                Path path = new Path(inputs.get(i).getFileName());

                FileSystem fs;
                boolean isFsPath = true;
                try {
                    fs = path.getFileSystem(conf);
                } catch (Exception e) {
                    // If an application specific
                    // scheme was used
                    // (e.g.: "hbase://table") we will fail
                    // getting the file system. That's
                    // ok, we just use the dfs in that case.
                    fs = new Path("/").getFileSystem(conf);
                    isFsPath = false;
                }

                // if the execution is against Mapred DFS, set
                // working dir to /user/<userid>
                if (!Utils.isLocal(pigContext, conf)) {
                    fs.setWorkingDirectory(jobcontext.getWorkingDirectory());
                }

                // first pass input location to the loader - for this send a
                // clone of the configuration we have - this is so that if the
                // loader (or the inputformat of the loader) decide to store the
                // input location into the configuration (for example,
                // FileInputFormat stores this in mapred.input.dir in the conf),
                // then for different inputs, the loader's don't end up
                // over-writing the same conf.
                FuncSpec loadFuncSpec = inputs.get(i).getFuncSpec();
                LoadFunc loadFunc = (LoadFunc) PigContext
                        .instantiateFuncFromSpec(loadFuncSpec);
                boolean combinable = !(loadFunc instanceof MergeJoinIndexer
                        || loadFunc instanceof IndexableLoadFunc || (loadFunc instanceof CollectableLoadFunc && loadFunc instanceof OrderedLoadFunc));
                if (combinable)
                    combinable = !conf.getBoolean("pig.noSplitCombination",
                            false);
                Configuration confClone = new Configuration(conf);
                Job inputSpecificJob = new Job(confClone);
                // Pass loader signature to LoadFunc and to InputFormat through
                // the conf
                passLoadSignature(loadFunc, i, inputSpecificJob
                        .getConfiguration());
                loadFunc.setLocation(inputs.get(i).getFileName(),
                        inputSpecificJob);
                // The above setLocation call could write to the conf within
                // the inputSpecificJob - use this updated conf

                // get the InputFormat from it and ask for splits
                InputFormat inpFormat = loadFunc.getInputFormat();
                // List<InputSplit> oneInputSplits = inpFormat.getSplits(
                // HadoopShims.createJobContext(inputSpecificJob.getConfiguration(),
                // jobcontext.getJobID()));

                List<InputSplit> oneInputSplits = getSplitsSample(jobcontext);

                List<InputSplit> oneInputPigSplits = getPigSplits(
                        oneInputSplits, i, inpTargets.get(i), HadoopShims
                                .getDefaultBlockSize(fs, isFsPath ? path : fs
                                        .getWorkingDirectory()), combinable,
                        confClone);
                splits.addAll(oneInputPigSplits);
            } catch (ExecException ee) {
                throw ee;
            } catch (Exception e) {
                int errCode = 2118;
                String msg = "Unable to create input splits for: "
                        + inputs.get(i).getFileName();
                if (e.getMessage() != null && (!e.getMessage().isEmpty())) {
                    throw new ExecException(e.getMessage(), errCode,
                            PigException.BUG, e);
                } else {
                    throw new ExecException(msg, errCode, PigException.BUG, e);
                }
            }
        }

        // XXX hadoop 20 new API integration: get around a hadoop 20 bug by
        // passing total # of splits to each split so that it can be retrieved
        // in the RecordReader method when called by mapreduce framework later.
        int n = splits.size();
        // also passing the multi-input flag to the back-end so that
        // the multi-input record counters can be created
        int m = inputs.size();

        boolean disableCounter = conf.getBoolean("pig.disable.counter", false);
        if ((m > 1) && disableCounter) {
            log.info("Disable Pig custom input counters");
        }

        for (InputSplit split : splits) {
            ((PigSplit) split).setTotalSplits(n);
            if (m > 1)
                ((PigSplit) split).setMultiInputs(true);
            ((PigSplit) split).setDisableCounter(disableCounter);
        }
        // shuffle --> return splits
        return splits;
    }

    protected List<InputSplit> getPigSplits(List<InputSplit> oneInputSplits,
            int inputIndex, ArrayList<OperatorKey> targetOps, long blockSize,
            boolean combinable, Configuration conf) throws IOException,
            InterruptedException {
        ArrayList<InputSplit> pigSplits = new ArrayList<InputSplit>();
        if (!combinable) {
            int splitIndex = 0;
            for (InputSplit inputSplit : oneInputSplits) {
                PigSplit pigSplit = new PigSplit(
                        new InputSplit[] { inputSplit }, inputIndex, targetOps,
                        splitIndex++);
                pigSplit.setConf(conf);
                pigSplits.add(pigSplit);
            }
            return pigSplits;
        } else {
            long maxCombinedSplitSize = conf.getLong(
                    "pig.maxCombinedSplitSize", 0);
            if (maxCombinedSplitSize == 0)
                // default is the block size
                maxCombinedSplitSize = 1024;
            List<List<InputSplit>> combinedSplits = MapRedUtil
                    .getCombinePigSplits(oneInputSplits, maxCombinedSplitSize,
                            conf);
            for (int i = 0; i < combinedSplits.size(); i++)
                pigSplits.add(createPigSplit(combinedSplits.get(i), inputIndex,
                        targetOps, i, conf));
            return pigSplits;
        }
    }

    private InputSplit createPigSplit(List<InputSplit> combinedSplits,
            int inputIndex, ArrayList<OperatorKey> targetOps, int splitIndex,
            Configuration conf) {
        PigSplit pigSplit = new PigSplit(combinedSplits
                .toArray(new InputSplit[0]), inputIndex, targetOps, splitIndex);
        pigSplit.setConf(conf);
        return pigSplit;
    }

    public static PigSplit getActiveSplit() {
        return activeSplit;
    }

    private static PigSplit activeSplit;

}
