import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmployeeDataRetrieval {

    // Method to add an employee
    public static void addEmployee(String name, String position, double salary) {
        Connection connection = JDBCConnection.getConnection();
        try {
            String query = "INSERT INTO employees (name, position, salary) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, position);
            preparedStatement.setDouble(3, salary);
            preparedStatement.executeUpdate();
            System.out.println("Employee added successfully!");
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to update an employee
    public static void updateEmployee(int id, String name, String position, double salary) {
        Connection connection = JDBCConnection.getConnection();
        try {
            String query = "UPDATE employees SET name = ?, position = ?, salary = ? WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, position);
            preparedStatement.setDouble(3, salary);
            preparedStatement.setInt(4, id);
            preparedStatement.executeUpdate();
            System.out.println("Employee updated successfully!");
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to delete an employee
    public static void deleteEmployee(int id) {
        Connection connection = JDBCConnection.getConnection();
        try {
            String query = "DELETE FROM employees WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            System.out.println("Employee deleted successfully!");
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to retrieve and display all employees
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

    // Main method to demonstrate CRUD operations
    public static void main(String[] args) {
        // Add employees
        addEmployee("John Doe", "Manager", 75000.00);
        addEmployee("Jane Smith", "Developer", 65000.00);

        // Update an employee
        updateEmployee(1, "John Doe", "Senior Manager", 85000.00);

        // Delete an employee
        deleteEmployee(2);

        // Retrieve and display all employees
        getEmployees();
    }
}
