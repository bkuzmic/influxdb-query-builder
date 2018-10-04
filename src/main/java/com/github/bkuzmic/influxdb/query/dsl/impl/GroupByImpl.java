package com.github.bkuzmic.influxdb.query.dsl.impl;

import com.github.bkuzmic.influxdb.query.dsl.GroupBy;

public class GroupByImpl extends AbstractOrderLimitImpl implements GroupBy {

    public GroupByImpl(StringBuilder sb) {
        super(sb);
    }

}
