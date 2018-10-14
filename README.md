# InfluxDb Query Builder

Build InfluxDb queries using fluent API builder. 
This library works best in a combination with: [influxdb-java](https://github.com/influxdata/influxdb-java)

Here is example of usage:

```java
import com.github.bkuzmic.influxdb.query.builder.impl.InfluxQueryBuilderImpl;
import static com.github.bkuzmic.influxdb.query.builder.InfluxQueryBuilder.*;

class App {

    public static void main(String[] args) {
        InfluxQueryBuilder influxQueryBuilder = new InfluxQueryBuilderImpl();
        
        List<String> nodes = new ArrayList<>();
        nodes.add("1");
        nodes.add("2");
        nodes.add("3");
        
        String query = 
            influxQueryDsl
                .create()
                .select(time(), value())
                .from("alarms")
                .where(
                    param("nodeId").eqs(nodes))
                .and(
                    param("nodeType").eqs("EDA"))
                .and(
                   param(time()).lte(1000L, Unit.MS))
                .groupBy(
                    time("5m"), "nodeId")
                .limit(1L)
                .build();    
        
        // generated query string will look like this:    
        // SELECT time, value
        //   FROM alarm_severities WHERE
        //   (nodeId='1' OR nodeId='2' OR nodeId='3') 
        //   AND nodeType='EDA' 
        //   AND time<=1000ms 
        //   GROUP BY time(5m), nodeId 
        //   LIMIT 1
    }

}
```
                
More examples can be found in [InfluxQueryBuilderTest](https://github.com/bkuzmic/influxdb-query-builder/tree/master/src/test/java/com/github/bkuzmic/influxdb/query/builder/InfluxQueryBuilderTest.java).               
