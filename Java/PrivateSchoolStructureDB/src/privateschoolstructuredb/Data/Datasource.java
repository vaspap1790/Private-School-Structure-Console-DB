package privateschoolstructuredb.Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Datasource {

    public static final String DB_NAME = "privateschoolstructure";
    public static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/" + DB_NAME + "?zeroDateTimeBehavior=CONVERT_TO_NULL"
            + "&useUnicode=true"
            + "&useJDBCCompliantTimezoneShift=true"
            + "&useLegacyDatetimeCode=false"
            + "&serverTimezone=UTC"
            + "&allowPublicKeyRetrieval=true"
            + "&useSSL=false";

    public static Connection conn;

    public boolean open() {
        try {
            conn = DriverManager.getConnection(DB_CONNECTION, "root", "babanila");
            return true;
        } catch (SQLException e) {
            System.out.println("Couldn't connect to database:" + e.getMessage());
            return false;
        }
    }

    public void close() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println("Couldn't close connection:" + e.getMessage());
        }
    }
}

