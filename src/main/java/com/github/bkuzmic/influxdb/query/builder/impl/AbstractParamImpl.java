package com.github.bkuzmic.influxdb.query.builder.impl;

import java.util.Collection;
import java.util.Iterator;

public abstract class AbstractParamImpl {

    protected String paramName;

    public AbstractParamImpl(String paramName) {
        this.paramName = paramName;
    }

    protected String appendMultipleEq(Collection values, String format) {
        StringBuilder sb = new StringBuilder();
        if (values.isEmpty()) {
            return "";
        } else if (values.size() == 1) {
            appendEq(sb, format, values.iterator().next());
        } else {
            sb.append("(");
            Iterator iterator = values.iterator();
            for (int i = 0; i < values.size(); i++) {
                appendEq(sb, format, iterator.next());
                if (i != values.size() - 1) {
                    sb.append(" OR ");
                } else {
                    sb.append(")");
                }
            }
        }
        return sb.toString();
    }

    protected void appendEq(StringBuilder sb, String format, Object value) {
        sb.append(String.format(format, paramName, value.toString()));
    }

    protected String format(String format, Object value) {
        if (value == null) return "";
        return String.format(format, paramName, value);
    }

}
