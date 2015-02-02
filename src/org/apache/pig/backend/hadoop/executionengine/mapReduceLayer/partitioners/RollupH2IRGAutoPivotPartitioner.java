package org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.partitioners;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.URI;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

import org.apache.hadoop.conf.Configurable;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.filecache.DistributedCache;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapreduce.lib.partition.HashPartitioner;
import org.apache.pig.PigConfiguration;
import org.apache.pig.data.Tuple;
import org.apache.pig.data.TupleFactory;
import org.apache.pig.impl.io.PigNullableWritable;

public class RollupH2IRGAutoPivotPartitioner extends
        HashPartitioner<PigNullableWritable, Writable> implements Configurable {

    protected MessageDigest m = null;
    protected int choosen = 0;
    protected HashMap<String, Integer> hm;
    protected int pivot = 0;
    protected int rollupFieldIndex = 0;
    protected int rollupOldFieldIndex = 0;
    protected boolean pivotZero = false;
    protected int length = 0;
    public static long tLookup = 0;
    public static long hashTime = 0;
    public long sTime = 0;

    public RollupH2IRGAutoPivotPartitioner() throws NoSuchAlgorithmException {
        m = MessageDigest.getInstance("MD5");
    }

    @Override
    public void setConf(Configuration conf) {
        sTime = System.currentTimeMillis();
        pivot = conf.getInt(PigConfiguration.PIG_H2IRG_ROLLUP_PIVOT, -1);
        rollupFieldIndex = conf.getInt(
                PigConfiguration.PIG_H2IRG_ROLLUP_FIELD_INDEX, 0);
        rollupOldFieldIndex = conf.getInt(
                PigConfiguration.PIG_H2IRG_ROLLUP_OLD_FIELD_INDEX, 0);
        length = conf.getInt(PigConfiguration.PIG_H2IRG_ROLLUP_TOTAL_FIELD, 0);
        // We must check the original pivot value before it is updated
        // if there are many rollup/cube.
        if (pivot == 0)
            pivotZero = true;

        if (rollupFieldIndex != 0)
            pivot = pivot + rollupFieldIndex;
        if (hm == null) {
            hm = new HashMap<String, Integer>();
            try {
                hm.clear();
                
                FileSystem fs = FileSystem.get(conf);
                
                Path[] localFiles = DistributedCache.getLocalCacheFiles(conf);
                Path cache = new Path(localFiles[0].toString());
                System.out.println(localFiles[0].toString());
                BufferedReader br = new BufferedReader(new InputStreamReader(FileSystem.getLocal(conf).open(
                        localFiles[0])));
                String line = br.readLine();
                while (line != null) {
                    String[] vals = line.toString().split("\t");
                    //if(vals.length > 1) {
                    TupleFactory mTupleFactory = TupleFactory.getInstance();
                    Tuple t = mTupleFactory.newTuple();
                    for (int i = 0; i < vals.length - 1; i++) {
                        if (vals[i].equals("null"))
                            t.append(null);
                        else
                            t.append(vals[i]);
                    }
                    int reducerNo = Integer.parseInt(vals[vals.length - 1]);
                    hm.put(t.toString(), new Integer(reducerNo));
                    //}
                    line = br.readLine();
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        hashTime += System.currentTimeMillis() - sTime;
    }

    @Override
    public Configuration getConf() {
        return null;
    }

    @Override
    public int getPartition(PigNullableWritable key, Writable value,
            int numPartitions) {
        try {
            sTime = System.currentTimeMillis();
            Tuple t = (Tuple) key.getValueAsPigType();
            if (pivotZero) {// We use IRG --> only one reducer.
                return 0;
            } else {
                if (t.get(pivot - 1) == null)// We transfer them to the
                                             // determined reducer.
                    if (t.size() > length ) {// Check if it is a special tuple
                        int lenSpecial = t.size();
                        // Send it to the reducer which has been decided before
                        // by the addition dimension we added in the cleanup
                        // phase
                        // of each map.
                        hashTime += System.currentTimeMillis() - sTime;
                        return (Integer) t.get(lenSpecial - 1);
                    } else {
                        hashTime += System.currentTimeMillis() - sTime;
                        //System.out.println(t.toString());
                        return 0;
                    }
                else {
                    
                    if (t.size() > length ) {// Check if it is a special tuple
                        int lenSpecial = t.size();
                        // Send it to the reducer which has been decided before
                        // by the addition dimension we added in the cleanup
                        // phase
                        // of each map.
                        hashTime += System.currentTimeMillis() - sTime;
                        return (Integer) t.get(lenSpecial - 1);
                    }
                    
                    TupleFactory mTupleFactory = TupleFactory.getInstance();
                    Tuple tmp = mTupleFactory.newTuple();

                    for (int i = 0; i < length; i++)
                        tmp.append(null);

                    for (int i = rollupFieldIndex; i < pivot; i++) {
                        if(t.get(i)==null)
                            break;
                        tmp.set(i, t.get(i));
                    }

                    long lookupS = System.currentTimeMillis();
                    Integer num = hm.get(tmp.toString());
                    tLookup += System.currentTimeMillis() - lookupS;

                    if (num == null) {
                        m.reset();
                        for (int i = rollupFieldIndex; i < pivot; i++) {
                            Object a = t.get(i);
                            ByteArrayOutputStream bos = new ByteArrayOutputStream();
                            ObjectOutputStream oos = new ObjectOutputStream(bos);
                            oos.writeObject(a);
                            oos.flush();
                            oos.close();
                            bos.close();
                            byte[] tmpB = bos.toByteArray();
                            m.update(ByteBuffer.allocate(tmpB.length).put(tmpB)
                                    .array());
                        }
                        hashTime += System.currentTimeMillis() - sTime;
                        return (m.digest()[15] & Integer.MAX_VALUE)
                                % numPartitions;
                    }
                    hashTime += System.currentTimeMillis() - sTime;
                    return (Integer) num;
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
