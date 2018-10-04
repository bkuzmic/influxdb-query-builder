package com.github.bkuzmic.influxdb.query.dsl;

import com.github.bkuzmic.influxdb.query.dsl.impl.OrderParamImpl;
import com.github.bkuzmic.influxdb.query.dsl.impl.QueryParamImpl;
import com.github.bkuzmic.influxdb.query.dsl.impl.TagParamImpl;

public interface InfluxQueryDsl {

    Select create();

    static String all() {
        return "*";
    }

    static String time() {
        return "time";
    }

    static String time(String interval) {
        return String.format("time(%s)", interval);
    }

    static String value() {
        return "value";
    }

    static String value(String as) {
        return String.format("value as %s", as);
    }

    static String last(String value) {
        return String.format("last(%s)", value);
    }

    static String last(String value, String as) {
        return String.format("last(%s) as %s", value, as);
    }

    static String sum(String value) {
        return String.format("sum(%s)", value);
    }

    static String count() {
        return count("*");
    }

    static String count(String value) {
        return String.format("count(%s)", value);
    }

    static OrderParam order(String name) {
        return new OrderParamImpl(name);
    }

    static QueryParam param(String name) {
        return new QueryParamImpl(name);
    }

    static QueryParam field(String name) {
        return new QueryParamImpl(name);
    }

    static TagParam tag(String name) {
        return new TagParamImpl(name);
    }

    enum Unit {
        MS("ms"),S("s"),NS("ns");

        private String unitName;

        Unit(String unitName) {
            this.unitName = unitName;
        }

        public String toString() {
            return this.unitName;
        }
    }

}
