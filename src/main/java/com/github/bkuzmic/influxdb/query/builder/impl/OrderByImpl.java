package com.github.bkuzmic.influxdb.query.builder.impl;

import com.github.bkuzmic.influxdb.query.builder.OrderBy;

public class OrderByImpl extends AbstractLimitImpl implements OrderBy {

    public OrderByImpl(StringBuilder sb) {
        super(sb);
    }
}
