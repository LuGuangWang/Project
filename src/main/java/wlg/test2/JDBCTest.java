package wlg.test2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JDBCTest {
  Logger log = LoggerFactory.getLogger(getClass());

  static Connection getMysqlConn() throws SQLException {
    String driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://10.202.202.43:3306/api?useUnicode=true&characterEncoding=utf8&allowMultiQueries=true&zeroDateTimeBehavior=convertToNull";
    String username = "api";
    String password = "p";
    Connection conn = null;
    try {
      // DriverManager requires the driver to be loaded via the system ClassLoader.
      Class.forName(driver);
    } catch (Exception e) {
      throw new SQLException("error setting driver.");
    }
    conn = DriverManager.getConnection(url, username, password);
    return conn;
  }
  
  private static Connection getSQLConn() throws SQLException {
    String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    String url = "jdbc:sqlserver://10.202.202.245;databaseName=BJ20140915";
    String username = "db_whbmowner";
    String password = "levitra5gt#";
    Connection conn = null;
    try {
      // DriverManager requires the driver to be loaded via the system ClassLoader.
      Class.forName(driver);
    } catch (Exception e) {
      throw new SQLException("error setting driver.");
    }
    conn = DriverManager.getConnection(url, username, password);
    return conn;
  }

  private static Integer getAll(Connection conn) throws SQLException {
    String sql = "select t.nSchoolId,t.sCode,t.sName from bs_class t where t.nSchoolId=1 and t.sCode='VIPTVS15465'";
    PreparedStatement pstmt;
    try {
      pstmt = conn.prepareStatement(sql);
      ResultSet rs = pstmt.executeQuery();
      int col = rs.getMetaData().getColumnCount();
      System.out.println("============================");
      while (rs.next()) {
        for (int i = 1; i <= col; i++) {
          System.out.print(rs.getMetaData().getColumnName(i) + "\t");
          System.out.print(rs.getMetaData().getColumnType(i) + "\t");
          System.out.print(rs.getString(i) + "\t");
          if ((i == 2) && (rs.getString(i).length() < 8)) {
            System.out.print("\t");
          }
        }
        System.out.println("");
      }
      System.out.println("============================");
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

  public static void main(String[] args) {
    try {
      getAll(getSQLConn());
      System.out.println();
      getAll(getMysqlConn());
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
