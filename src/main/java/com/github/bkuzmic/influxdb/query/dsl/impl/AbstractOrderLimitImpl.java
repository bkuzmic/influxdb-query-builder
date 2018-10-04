package com.github.bkuzmic.influxdb.query.dsl.impl;

import com.github.bkuzmic.influxdb.query.dsl.OrderBy;
import com.github.bkuzmic.influxdb.query.dsl.OrderLimit;

public class AbstractOrderLimitImpl extends AbstractLimitImpl implements OrderLimit {

    protected AbstractOrderLimitImpl(StringBuilder sb) {
        super(sb);
    }

    @Override
    public OrderBy orderBy(String... orderByNames) {
        appendNames(sb, "ORDER BY", orderByNames);
        return new OrderByImpl(sb);
    }

    protected void appendNames(StringBuilder sb, String method, String... names) {
        sb.append(method + " ");
        for (int i=0; i<names.length; i++) {
            sb.append(names[i]);
            if (i != names.length - 1) {
                sb.append(", ");
            } else {
                sb.append(" ");
            }
        }
    }

}
