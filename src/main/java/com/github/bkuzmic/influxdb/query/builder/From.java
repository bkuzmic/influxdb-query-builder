package com.github.bkuzmic.influxdb.query.builder;

public interface From {

    Where from(String tableName);
    Where from(Builder subSelect);

}
