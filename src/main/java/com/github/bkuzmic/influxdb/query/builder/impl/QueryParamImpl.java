package com.github.bkuzmic.influxdb.query.builder.impl;

import com.github.bkuzmic.influxdb.query.builder.InfluxQueryBuilder;
import com.github.bkuzmic.influxdb.query.builder.QueryParam;

import java.util.Collection;

public class QueryParamImpl extends AbstractParamImpl implements QueryParam {

    public QueryParamImpl(String paramName) {
        super(paramName);
    }

    @Override
    public String eq(Number value) {
        return format("%s=%s", value);
    }

    @Override
    public String eqs(String value) {
        return format("%s='%s'", value);
    }

    @Override
    public String eq(Collection values) {
        return appendMultipleEq(values, "%s=%s");
    }

    @Override
    public String eqs(Collection values) {
        return appendMultipleEq(values, "%s='%s'");
    }


    @Override
    public String notEq(Number value) {
        return format("%s !=%s", value);
    }

    @Override
    public String notEqs(String value) {
        return format("%s !='%s'", value);
    }

    @Override
    public String lt(Number value) {
        return format("%s<%s", value);
    }

    @Override
    public String lt(Number value, InfluxQueryBuilder.Unit unit) {
        if (lt(value).isEmpty()) {
            return "";
        }
        return lt(value) + unit.toString();
    }

    @Override
    public String lte(Number value) {
        return format("%s<=%s", value);
    }

    @Override
    public String lte(Number value, InfluxQueryBuilder.Unit unit) {
        if (lte(value).isEmpty()) {
            return "";
        }
        return lte(value) + unit.toString();
    }

    @Override
    public String gt(Number value) {
        return format("%s>%s", value);
    }

    @Override
    public String gt(Number value, InfluxQueryBuilder.Unit unit) {
        if (gt(value).isEmpty()) {
            return "";
        }
        return gt(value) + unit.toString();
    }

    @Override
    public String gte(Number value) {
        return format("%s>=%s", value);
    }

    @Override
    public String gte(Number value, InfluxQueryBuilder.Unit unit) {
        if (gte(value).isEmpty()) {
            return "";
        }
        return gte(value) + unit.toString();
    }

}
