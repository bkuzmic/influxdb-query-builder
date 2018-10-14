package com.github.bkuzmic.influxdb.query.builder.impl;

import com.github.bkuzmic.influxdb.query.builder.And;
import com.github.bkuzmic.influxdb.query.builder.Where;

public class WhereImpl extends AbstractGroupOrderLimitImpl implements Where {

    public WhereImpl(StringBuilder sb) {
        super(sb);
    }

    @Override
    public And where(String queryParam) {
        if (queryParam != null && !queryParam.isEmpty()) {
            this.sb.append("WHERE " + queryParam + " ");
        }
        return new AndImpl(sb);
    }

}
