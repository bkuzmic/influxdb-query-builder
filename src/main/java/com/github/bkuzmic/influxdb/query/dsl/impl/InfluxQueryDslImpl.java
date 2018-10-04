package com.github.bkuzmic.influxdb.query.dsl.impl;

import com.github.bkuzmic.influxdb.query.dsl.InfluxQueryDsl;
import com.github.bkuzmic.influxdb.query.dsl.Select;

public class InfluxQueryDslImpl extends AbstractBuilder implements InfluxQueryDsl {

    public InfluxQueryDslImpl() {
       super(new StringBuilder());
    }

    @Override
    public Select create() {
        this.sb = new StringBuilder();
        return new SelectImpl(sb);
    }
}
