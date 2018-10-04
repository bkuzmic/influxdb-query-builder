package com.github.bkuzmic.influxdb.query.dsl.impl;

import com.github.bkuzmic.influxdb.query.dsl.Builder;

public abstract class AbstractBuilder implements Builder {

    protected StringBuilder sb;

    protected AbstractBuilder(StringBuilder sb) {
        this.sb = sb;
    }

    @Override
    public String build() {
        return this.sb.toString().trim();
    }
}
