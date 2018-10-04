package com.github.bkuzmic.influxdb.query.dsl;

import java.util.Collection;

public interface QueryParam {

    String eq(Number value);
    String eqs(String value);

    String eq(Collection values);
    String eqs(Collection values);

    String notEq(Number value);
    String notEqs(String value);

    String lt(Number value);
    String lt(Number value, InfluxQueryDsl.Unit unit);
    String lte(Number value);
    String lte(Number value, InfluxQueryDsl.Unit unit);

    String gt(Number value);
    String gt(Number value, InfluxQueryDsl.Unit unit);
    String gte(Number value);
    String gte(Number value, InfluxQueryDsl.Unit unit);

}
