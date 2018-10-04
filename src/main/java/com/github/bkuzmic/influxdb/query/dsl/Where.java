package com.github.bkuzmic.influxdb.query.dsl;

public interface Where extends GroupOrderLimit {

    And where(String queryParam);

}
