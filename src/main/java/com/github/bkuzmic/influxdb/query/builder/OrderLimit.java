package com.github.bkuzmic.influxdb.query.builder;

public interface OrderLimit extends Limit {

    OrderBy orderBy(String... orderByNames);

}
