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
    String url = "jdbc:mysql://XXXX:3306/api?useUnicode=true&characterEncoding=utf8&allowMultiQueries=true&zeroDateTimeBehavior=convertToNull";
    String username = "xxx";
    String password = "xxx";
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
    String url = "jdbc:sqlserver://XXXX;databaseName=XXXX";
    String username = "xxx";
    String password = "xxx";
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
//    String sql = "select t.nSchoolId,t.sCode,t.sName from bs_class t where t.nSchoolId=? and t.sCode=? limit ?,?";
    String sql = "select top 10 id,scode,sname from ( select top 30 id,sCode,sname from bs_class where nschoolid=1 AND  (dtEndDate>getdate()) order by sCode asc)tmp  order by sCode desc";
    PreparedStatement pstmt;
    try {
      pstmt = conn.prepareStatement(sql);
//      pstmt.setInt(1, 10);
//      pstmt.setString(2, "CMQALL20164016");
//      pstmt.setInt(3, 0);
//      pstmt.setInt(4, 20);
      ResultSet rs = pstmt.executeQuery();
      int col = rs.getMetaData().getColumnCount();
      System.out.println("============================");
      while (rs.next()) {
        for (int i = 1; i <= col; i++) {
          System.out.print(rs.getMetaData().getColumnName(i) + "\t");
          System.out.print(rs.getMetaData().getColumnTypeName(i) + "\t");
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
