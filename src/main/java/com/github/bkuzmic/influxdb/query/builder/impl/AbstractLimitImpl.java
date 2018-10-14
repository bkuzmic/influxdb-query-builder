package com.github.bkuzmic.influxdb.query.builder.impl;

import com.github.bkuzmic.influxdb.query.builder.Builder;
import com.github.bkuzmic.influxdb.query.builder.Limit;

public abstract class AbstractLimitImpl extends AbstractBuilder implements Limit {

    protected AbstractLimitImpl(StringBuilder sb) {
        super(sb);
    }

    @Override
    public Builder limit(Long numberOfRecords) {
        this.sb.append("LIMIT " + numberOfRecords);
        return new BaseBuilder(sb);
    }
}
