import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/employee_db";
    private static final String USER = "root";  // Replace with your MySQL username
    private static final String PASSWORD = "password";  // Replace with your MySQL password

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
