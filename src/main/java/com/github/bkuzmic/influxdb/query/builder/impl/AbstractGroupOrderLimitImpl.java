package com.github.bkuzmic.influxdb.query.builder.impl;

import com.github.bkuzmic.influxdb.query.builder.GroupBy;
import com.github.bkuzmic.influxdb.query.builder.GroupOrderLimit;

public class AbstractGroupOrderLimitImpl extends AbstractOrderLimitImpl implements GroupOrderLimit {

    protected AbstractGroupOrderLimitImpl(StringBuilder sb) {
        super(sb);
    }

    @Override
    public GroupBy groupBy(String... groupNames) {
        appendNames(sb, "GROUP BY", groupNames);
        return new GroupByImpl(sb);
    }


}
