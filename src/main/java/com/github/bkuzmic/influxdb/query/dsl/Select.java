package com.github.bkuzmic.influxdb.query.dsl;

public interface Select {

    From select(String... tagOrField);

}
