package com.github.bkuzmic.influxdb.query.builder;

public interface Select {

    From select(String... tagOrField);

}
