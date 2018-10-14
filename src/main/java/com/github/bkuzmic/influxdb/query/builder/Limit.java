package com.github.bkuzmic.influxdb.query.builder;

public interface Limit extends Builder {

    Builder limit(Long numberOfRecords);

}
