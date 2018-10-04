package com.github.bkuzmic.influxdb.query.dsl;

public interface OrderBy extends Builder {

    Builder limit(Long numberOfRecords);

}
