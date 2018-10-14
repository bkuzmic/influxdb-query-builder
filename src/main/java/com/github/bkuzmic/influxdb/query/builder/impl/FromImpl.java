package com.github.bkuzmic.influxdb.query.builder.impl;

import com.github.bkuzmic.influxdb.query.builder.Builder;
import com.github.bkuzmic.influxdb.query.builder.From;
import com.github.bkuzmic.influxdb.query.builder.Where;

public class FromImpl extends AbstractBuilder implements From {

    public FromImpl(StringBuilder sb) {
        super(sb);
    }

    @Override
    public Where from(String tableName) {
        sb.append("FROM " + tableName + " ");
        return new WhereImpl(sb);
    }

    @Override
    public Where from(Builder subSelect) {
        sb.append("FROM (" + subSelect.build() + ") ");
        return new WhereImpl(sb);
    }
}
