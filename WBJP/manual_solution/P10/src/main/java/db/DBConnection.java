package db;
import java.sql.*;

public class DBConnection {
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/studentdb", "root", ""
            );
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
