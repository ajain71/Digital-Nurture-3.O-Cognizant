import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmployeeDataRetrieval {

    public static void getEmployees() {
        Connection connection = JDBCConnection.getConnection();
        try {
            String query = "SELECT * FROM employees";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String position = resultSet.getString("position");
                double salary = resultSet.getDouble("salary");
                System.out.println("ID: " + id + ", Name: " + name + ", Position: " + position + ", Salary: " + salary);
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        getEmployees();
    }
}
