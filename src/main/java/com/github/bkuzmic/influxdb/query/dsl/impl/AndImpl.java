package com.github.bkuzmic.influxdb.query.dsl.impl;

import com.github.bkuzmic.influxdb.query.dsl.And;

public class AndImpl extends AbstractGroupOrderLimitImpl implements And {

    public AndImpl(StringBuilder sb) {
        super(sb);
    }

    @Override
    public And and(String queryParam) {
        if (queryParam != null && !queryParam.isEmpty()) {
            this.sb.append("AND " + queryParam +" ");
        }
        return new AndImpl(sb);
    }

}
