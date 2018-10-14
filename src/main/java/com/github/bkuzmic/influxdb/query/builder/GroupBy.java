package com.github.bkuzmic.influxdb.query.builder;

public interface GroupBy extends Builder {

    OrderBy orderBy(String... orderByNames);
    Builder limit(Long numberOfRecords);

}
