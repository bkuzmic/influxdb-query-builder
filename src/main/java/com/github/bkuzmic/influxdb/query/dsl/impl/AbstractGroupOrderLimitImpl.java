package com.github.bkuzmic.influxdb.query.dsl.impl;

import com.github.bkuzmic.influxdb.query.dsl.GroupBy;
import com.github.bkuzmic.influxdb.query.dsl.GroupOrderLimit;

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
