package com.github.bkuzmic.influxdb.query.dsl;

public interface OrderLimit extends Limit {

    OrderBy orderBy(String... orderByNames);

}
