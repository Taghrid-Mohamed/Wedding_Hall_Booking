package db_MA;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import util_ES.LoggerUtil_ES;   // 👈 زيدي هالإمبورت

public class DBConnection_MA {

    private static final String URL  = "jdbc:mysql://localhost:3306/event_system";
    private static final String USER = "root";
    private static final String PASS = "";

    private static Connection conn = null;

    public static Connection getConnection() throws SQLException {
        try {
            if (conn == null || conn.isClosed()) {
                conn = DriverManager.getConnection(URL, USER, PASS);
                LoggerUtil_ES.logInfo("DB connection opened successfully.");
            }
        } catch (SQLException ex) {
            LoggerUtil_ES.logError("DB connection failed: " + ex.getMessage());
            throw ex; // نرجع الخطأ عادي
        }
        return conn;
    }
}
