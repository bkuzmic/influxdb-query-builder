package com.github.bkuzmic.influxdb.query.builder;

import java.util.Collection;

public interface TagParam {

    String eqs(Object value);
    String eqs(Collection values);

    String notEqs(Object value);

}
