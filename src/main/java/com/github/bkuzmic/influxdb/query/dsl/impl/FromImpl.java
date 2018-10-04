package com.github.bkuzmic.influxdb.query.dsl.impl;

import com.github.bkuzmic.influxdb.query.dsl.Builder;
import com.github.bkuzmic.influxdb.query.dsl.From;
import com.github.bkuzmic.influxdb.query.dsl.Where;

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
