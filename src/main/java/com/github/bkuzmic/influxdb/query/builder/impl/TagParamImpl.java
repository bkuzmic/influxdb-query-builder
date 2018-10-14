package com.github.bkuzmic.influxdb.query.builder.impl;

import com.github.bkuzmic.influxdb.query.builder.TagParam;

import java.util.Collection;

public class TagParamImpl extends AbstractParamImpl implements TagParam {

    public TagParamImpl(String paramName) {
        super(paramName);
    }

    @Override
    public String eqs(Object value) {
        return format("%s='%s'", value.toString());
    }

    @Override
    public String eqs(Collection values) {
        return appendMultipleEq(values, "%s='%s'");
    }

    @Override
    public String notEqs(Object value) {
        return format("%s !='%s'", value.toString());
    }
}
