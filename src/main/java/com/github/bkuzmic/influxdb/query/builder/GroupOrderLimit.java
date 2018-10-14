package com.github.bkuzmic.influxdb.query.builder;

public interface GroupOrderLimit extends OrderLimit {

    GroupBy groupBy(String... groupNames);

}
