package com.github.bkuzmic.influxdb.query.dsl.impl;

import com.github.bkuzmic.influxdb.query.dsl.And;
import com.github.bkuzmic.influxdb.query.dsl.Where;

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
