package com.github.bkuzmic.influxdb.query.dsl;

public interface And extends GroupOrderLimit {

    And and(String queryParam);

}
