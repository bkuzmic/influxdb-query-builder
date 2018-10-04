package com.github.bkuzmic.influxdb.query.dsl.impl;

import com.github.bkuzmic.influxdb.query.dsl.Builder;
import com.github.bkuzmic.influxdb.query.dsl.Limit;

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
