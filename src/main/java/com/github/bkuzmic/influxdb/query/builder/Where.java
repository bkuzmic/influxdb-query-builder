package com.github.bkuzmic.influxdb.query.builder;

public interface Where extends GroupOrderLimit {

    And where(String queryParam);

}
