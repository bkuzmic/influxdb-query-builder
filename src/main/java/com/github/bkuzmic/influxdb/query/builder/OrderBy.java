package com.github.bkuzmic.influxdb.query.builder;

public interface OrderBy extends Builder {

    Builder limit(Long numberOfRecords);

}
