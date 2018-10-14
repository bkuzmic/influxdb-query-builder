package com.github.bkuzmic.influxdb.query.builder.impl;

import com.github.bkuzmic.influxdb.query.builder.GroupBy;

public class GroupByImpl extends AbstractOrderLimitImpl implements GroupBy {

    public GroupByImpl(StringBuilder sb) {
        super(sb);
    }

}
