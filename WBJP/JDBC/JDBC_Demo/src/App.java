import java.sql.*;

public class App {
    public static void main(String[] args) throws Exception {
        // Load the MySQL JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Database connection details
        String url = "jdbc:mysql://localhost:3306/database_name"; // Replace with your database name
        String user = "root";
        String password = "";

        // Establish the connection
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connected to the database!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
