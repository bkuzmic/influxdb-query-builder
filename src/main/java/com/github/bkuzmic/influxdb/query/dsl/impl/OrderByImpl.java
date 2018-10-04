package com.github.bkuzmic.influxdb.query.dsl.impl;

import com.github.bkuzmic.influxdb.query.dsl.OrderBy;

public class OrderByImpl extends AbstractLimitImpl implements OrderBy {

    public OrderByImpl(StringBuilder sb) {
        super(sb);
    }
}
