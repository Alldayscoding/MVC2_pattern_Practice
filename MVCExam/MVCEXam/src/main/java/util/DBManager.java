package util;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBManager {

    public static Connection getConnection(){
        Connection conn=null;

        try {
            Context initContext = new InitialContext();
            Context envContext  = (Context)initContext.lookup("java:/comp/env");
            DataSource ds = (DataSource)envContext.lookup("jdbc/oracle");
            conn = ds.getConnection();


        } catch (Exception e){e.printStackTrace();}
        return conn;
    }

    public static void close(Connection conn, Statement stmt, ResultSet rs) {
        try {
            rs.close();
            stmt.close();
            conn.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    // insert update delete 작업을 수행한 후 리소스 헤제
    public static void close(Connection conn, Statement stmt) {
        try {
            stmt.close();
            conn.close();
        }catch (Exception e){e.printStackTrace();}
    }
}
