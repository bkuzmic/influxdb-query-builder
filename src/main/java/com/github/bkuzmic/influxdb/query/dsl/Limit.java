package com.github.bkuzmic.influxdb.query.dsl;

public interface Limit extends Builder {

    Builder limit(Long numberOfRecords);

}
