package wlg.javaapi.demo.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.jdbc.ReplicationConnection;
import com.mysql.jdbc.ReplicationDriver;

/**
 * 读写分离
 */
public class ConnectUtil {

  public void queryCityList() throws SQLException {
    ReplicationConnection conn = (ReplicationConnection) readOnlyConn();
    
    System.out.println("slave connection: " + conn.getSlavesConnection().getHost());

    ResultSet rs = conn.createStatement().executeQuery("SELECT name FROM city where school_id=7");
    if (rs.next()) {
      System.out.println(rs.getString("name"));
    }

    conn.close();
  }

  private Connection readOnlyConn() throws SQLException {
    ReplicationDriver driver = new ReplicationDriver();
    Properties props = configProperties();

    //
    // Looks like a normal MySQL JDBC url, with a
    // comma-separated list of hosts, the first
    // being the 'master', the rest being any number
    // of slaves that the driver will load balance against
    //
    Connection conn = driver.connect("jdbc:mysql:replication://XXXX:3306,XXX:3306,XXX:3306/api?useUnicode=true&characterEncoding=utf8&allowMultiQueries=true&zeroDateTimeBehavior=convertToNull",
                                     props);

    //
    // Now, do a query from a slave, the driver automatically picks one
    // from the list
    //
    conn.setReadOnly(true);
    return conn;
  }

  private Properties configProperties() {
    Properties props = new Properties();

    // We want this for failover on the slaves
    props.put("autoReconnect", "true");

    // We want to load balance between the slaves
    props.put("roundRobinLoadBalance", "true");

    props.put("user", "XXX");
    props.put("password", "XXX");
    return props;
  }
  
  public static void main(String[] args){
    ConnectUtil dao = new ConnectUtil();
    for (int i = 0; i < 10; i++)
      try {
        dao.queryCityList();
      } catch (SQLException e) {
      }
  }
}
