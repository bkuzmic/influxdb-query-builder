package com.github.bkuzmic.influxdb.query.dsl.impl;

import com.github.bkuzmic.influxdb.query.dsl.From;
import com.github.bkuzmic.influxdb.query.dsl.Select;

public class SelectImpl extends AbstractBuilder implements Select {

    public SelectImpl(StringBuilder sb) {
        super(sb);
    }

    @Override
    public From select(String... tagsOrFields) {
        sb.append("SELECT ");
        for (int i=0; i<tagsOrFields.length; i++) {
            sb.append(tagsOrFields[i]);
            if (i != tagsOrFields.length - 1) {
                sb.append(", ");
            } else {
                sb.append(" ");
            }
        }
        return new FromImpl(sb);
    }
}
