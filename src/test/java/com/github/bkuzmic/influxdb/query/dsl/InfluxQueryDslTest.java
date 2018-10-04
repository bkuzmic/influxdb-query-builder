package com.github.bkuzmic.influxdb.query.dsl;

import com.github.bkuzmic.influxdb.query.dsl.impl.InfluxQueryDslImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static com.github.bkuzmic.influxdb.query.dsl.InfluxQueryDsl.*;

public class InfluxQueryDslTest {

    private InfluxQueryDsl influxQueryDsl;

    @Before
    public void setUp() {
        this.influxQueryDsl = new InfluxQueryDslImpl();
    }

    @Test
    public void testSelectWithMultipleOrAndParams() {
        List<String> nodes = new ArrayList<>();
        nodes.add("1");
        nodes.add("2");
        nodes.add("3");

        String query = influxQueryDsl
                .create()
                .select(time(), value(), value("alarmId"), last(value()), last(value(), "test"))
                .from("alarm_severities")
                .where(
                        param("nodeId").eqs(nodes))
                .and(
                        param("nodeType").eqs("EDA-PG"))
                .and(
                        param(time()).lte(1000L, Unit.MS))
                .groupBy(
                        time("5m"), "nodeId")
                .limit(1L).build();

        String expectedQuery = "SELECT time, value, value as alarmId, last(value), last(value) as test " +
                "FROM alarm_severities WHERE " +
                "(nodeId='1' OR nodeId='2' OR nodeId='3') AND nodeType='EDA-PG' AND time<=1000ms " +
                "GROUP BY time(5m), nodeId LIMIT 1";

        Assert.assertEquals("SQL query must match", expectedQuery, query);
    }

    @Test
    public void testNullParams() {
        String query = influxQueryDsl
                .create()
                .select(time(), value(), value("alarmId"), last(value()))
                .from("alarm_severities")
                .where(
                        param("nodeType").eqs("EDA-PG"))
                .and(
                        param("nodeId").eqs(Collections.emptySet()))
                .and(
                        param(time()).lte(1000L, Unit.MS))
                .and(
                        param(time()).lte(null, Unit.S))
                .and(
                        param(time()).lt(null, Unit.S))
                .and(
                        param(time()).gt(null, Unit.S))
                .and(
                        param(time()).gte(null, Unit.NS))
                .groupBy(
                        time("5m"), "nodeId")
                .limit(1L).build();

        String expectedQuery = "SELECT time, value, value as alarmId, last(value) FROM alarm_severities WHERE " +
                "nodeType='EDA-PG' AND time<=1000ms " +
                "GROUP BY time(5m), nodeId LIMIT 1";

        Assert.assertEquals("SQL query must match", expectedQuery, query);
    }

    @Test
    public void testValidParams() {
        String query = influxQueryDsl.create().select(value()).from("alarms")
                .where(param(time()).lte(100))
                .and(param(time()).lt(200L))
                .and(param(time()).gt(50))
                .and(param(time()).gte(60L))
                .and(param("severity").eq(1))
                .build();

        String expectedQuery = "SELECT value FROM alarms WHERE " +
                "time<=100 AND time<200 AND time>50 AND time>=60 AND severity=1";

        Assert.assertEquals("SQL query must match", expectedQuery, query);

        Set<Long> severityIds = new HashSet<>();
        severityIds.add(1L);

        query = influxQueryDsl.create().select(value()).from("alarms")
                .where(param(time()).lte(100L, Unit.NS) )
                .and(param(time()).lt(200L, Unit.NS))
                .and(param(time()).gt(50L, Unit.S))
                .and(param(time()).gte(60L, Unit.MS))
                .and(param(time()).notEq(70L))
                .and(param("nodeId").notEqs("100"))
                .and(param("severity").eq(severityIds))
                .build();

        expectedQuery = "SELECT value FROM alarms WHERE " +
                "time<=100ns AND time<200ns AND time>50s AND time>=60ms" +
                " AND time !=70 AND nodeId !='100' AND severity=1";

        Assert.assertEquals("SQL query must match", expectedQuery, query);
    }

    @Test
    public void testTagParam() {
        String query = influxQueryDsl.create().select(value()).from("alarms")
                .where(tag("counterId").eqs("10"))
                .build();

        String expectedQuery = "SELECT value FROM alarms WHERE " +
                "counterId='10'";

        Assert.assertEquals("SQL query must match", expectedQuery, query);

        Set<String> counterIds = new HashSet<>();
        counterIds.add("1");
        counterIds.add("2");
        counterIds.add("3");

        query = influxQueryDsl.create().select(value()).from("alarms")
                .where(tag("counterId").eqs(counterIds))
                .and(tag("nodeId").notEqs("5"))
                .build();

        expectedQuery = "SELECT value FROM alarms WHERE " +
                "(counterId='1' OR counterId='2' OR counterId='3') AND nodeId !='5'";

        Assert.assertEquals("SQL query must match", expectedQuery, query);
    }

    @Test
    public void testFieldAsAliasForParam() {
        String query = influxQueryDsl.create().select(value()).from("alarms")
                .where(field("severity").eqs("warning"))
                .build();

        String expectedQuery = "SELECT value FROM alarms WHERE " +
                "severity='warning'";

        Assert.assertEquals("SQL query must match", expectedQuery, query);
    }

    @Test
    public void testLimitWithoutWhere() {
        String query = influxQueryDsl
                .create()
                .select(time(), value())
                .from("alarms")
                .limit(1L).build();

        String expectedQuery = "SELECT time, value FROM alarms LIMIT 1";

        Assert.assertEquals("SQL query must match", expectedQuery, query);
    }

    @Test
    public void testLimitWithoutGroupBy() {
        String query = influxQueryDsl
                .create()
                .select(time(), value())
                .from("alarms")
                .where(param("severity").eqs("warning"))
                .limit(1L).build();

        String expectedQuery = "SELECT time, value FROM alarms WHERE severity='warning' LIMIT 1";

        Assert.assertEquals("SQL query must match", expectedQuery, query);
    }

    @Test
    public void testOrderByDesc() {
        String query = influxQueryDsl
                .create()
                .select(count())
                .from("alarms")
                .where(param("systemId").eqs("1"))
                .orderBy(order("severity").desc())
                .build();

        String expectedQuery = "SELECT count(*) FROM alarms WHERE systemId='1' ORDER BY severity DESC";
        Assert.assertEquals("SQL query must match", expectedQuery, query);
    }

    @Test
    public void testOrderByAsc() {
        String query = influxQueryDsl
                .create()
                .select(count())
                .from("alarms")
                .where(param("systemId").eqs("2"))
                .orderBy(order("severity").asc())
                .build();

        String expectedQuery = "SELECT count(*) FROM alarms WHERE systemId='2' ORDER BY severity ASC";
        Assert.assertEquals("SQL query must match", expectedQuery, query);
    }


    @Test
    public void testSelectCount() {
        String query = influxQueryDsl.create().select(count()).from("counters")
                .where(param("counterId").eqs("4")).build();

        String expectedQuery = "SELECT count(*) FROM counters WHERE counterId='4'";

        Assert.assertEquals("SQL query must match", expectedQuery, query);
    }

    @Test
    public void testSelectCountValue() {
        String query = influxQueryDsl.create().select(count("nodeId")).from("counters")
                .where(param("counterId").eqs("4")).build();

        String expectedQuery = "SELECT count(nodeId) FROM counters WHERE counterId='4'";

        Assert.assertEquals("SQL query must match", expectedQuery, query);
    }

    @Test
    public void testSubSelect() {
        String query = influxQueryDsl.create().select(count())
                .from(
                    influxQueryDsl.create().select(time()).from("alarms"))
                .where(param("systemId").eqs("3")).build();

        String expectedQuery = "SELECT count(*) FROM (SELECT time FROM alarms) WHERE systemId='3'";

        Assert.assertEquals("SQL query must match", expectedQuery, query);
    }

    @Test
    public void testComplexSubSelect() {
        List<Long> counterIds = new ArrayList<Long>() {{
            add(1L);
            add(2L);
        }};

        String query = influxQueryDsl.create()
                .select(all())
                .from(
                        influxQueryDsl.create().select(sum("last"))
                                .from(
                                        influxQueryDsl.create().select(last(value())).from("counters")
                                                .where(param("counterId").eqs(counterIds))
                                                .and(param(time()).lte(1000L, Unit.MS))
                                                .groupBy("counterId", time("5m"))
                                                .orderBy(order(time()).desc())
                                )
                                .groupBy(time("5m"))
                                .orderBy(order(time()).desc())
                )
                .orderBy(order(time()).desc())
                .limit(1L)
                .build();


        String expectedQuery = "SELECT * FROM (SELECT sum(last) FROM (SELECT last(value) FROM counters " +
                "WHERE (counterId='1' OR counterId='2') AND time<=1000ms GROUP BY counterId, time(5m)" +
                " ORDER BY time DESC) GROUP BY time(5m) ORDER BY time DESC) ORDER BY time DESC LIMIT 1";

        Assert.assertEquals("SQL query must match", expectedQuery, query);
    }

}
