package org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.partitioners;

import org.apache.hadoop.conf.Configurable;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapreduce.lib.partition.HashPartitioner;
import org.apache.pig.impl.io.PigNullableWritable;

public class HPartitioner extends HashPartitioner<PigNullableWritable, Writable> implements Configurable {

    public HPartitioner() {
        super();
    }

    @Override
    public int getPartition(PigNullableWritable key, Writable value, int numPartitions) {
        //
        return 0;
    }

    @Override
    public Configuration getConf() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setConf(Configuration conf) {
    }
}