package com.github.bkuzmic.influxdb.query.dsl;

public interface GroupOrderLimit extends OrderLimit {

    GroupBy groupBy(String... groupNames);

}
