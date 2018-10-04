package com.github.bkuzmic.influxdb.query.dsl;

public interface GroupBy extends Builder {

    OrderBy orderBy(String... orderByNames);
    Builder limit(Long numberOfRecords);

}
