import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/employee_db";
    private static final String USER = "root";  // Replace with your MySQL username
    private static final String PASSWORD = "password";  // Replace with your MySQL password

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connection to MySQL database established successfully!");
        } catch (SQLException e) {
            System.out.println("Failed to connect to MySQL database!");
            e.printStackTrace();
        }
        return connection;
    }

    public static void main(String[] args) {
        getConnection();  // Test the connection
    }
}
