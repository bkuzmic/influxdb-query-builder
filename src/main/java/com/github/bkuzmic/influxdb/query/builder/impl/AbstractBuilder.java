package com.github.bkuzmic.influxdb.query.builder.impl;

import com.github.bkuzmic.influxdb.query.builder.Builder;

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
