package com.github.bkuzmic.influxdb.query.builder.impl;

import com.github.bkuzmic.influxdb.query.builder.InfluxQueryBuilder;
import com.github.bkuzmic.influxdb.query.builder.Select;

public class InfluxQueryBuilderImpl extends AbstractBuilder implements InfluxQueryBuilder {

    public InfluxQueryBuilderImpl() {
       super(new StringBuilder());
    }

    @Override
    public Select create() {
        this.sb = new StringBuilder();
        return new SelectImpl(sb);
    }
}
