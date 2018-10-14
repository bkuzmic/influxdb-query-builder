package com.github.bkuzmic.influxdb.query.builder;

public interface And extends GroupOrderLimit {

    And and(String queryParam);

}
