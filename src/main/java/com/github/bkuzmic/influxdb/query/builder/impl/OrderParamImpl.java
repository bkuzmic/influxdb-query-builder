package com.github.bkuzmic.influxdb.query.builder.impl;

import com.github.bkuzmic.influxdb.query.builder.OrderParam;

public class OrderParamImpl implements OrderParam {

    private String paramName;

    public OrderParamImpl(String paramName) {
        this.paramName = paramName;
    }

    @Override
    public String asc() {
        return String.format("%s %s", paramName, "ASC");
    }

    @Override
    public String desc() {
        return String.format("%s %s", paramName, "DESC");
    }

}
