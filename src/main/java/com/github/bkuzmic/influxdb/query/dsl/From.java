package com.github.bkuzmic.influxdb.query.dsl;

public interface From {

    Where from(String tableName);
    Where from(Builder subSelect);

}
