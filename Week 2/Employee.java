
public class Employee {
    private int id;
    private String name;
    private String address;

    public Employee(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String newAddress) {
        this.address = newAddress;
    }

    @Override
    public String toString() {
        return "Employee ID: " + id + ", Name: " + name + ", Address: " + address;
    }
}


import java.util.ArrayList;

public class EmployeeManagement {
    private ArrayList<Employee> employees;

    public EmployeeManagement() {
        employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
        System.out.println(employee.getName() + " added to the system.");
    }

    public void removeEmployee(int employeeId) {
        employees.removeIf(e -> e.getId() == employeeId);
        System.out.println("Employee with ID " + employeeId + " removed from the system.");
    }

    public void updateEmployee(int employeeId, String newAddress) {
        for (Employee e : employees) {
            if (e.getId() == employeeId) {
                e.setAddress(newAddress);
                System.out.println("Updated address for employee ID " + employeeId);
                break;
            }
        }
    }

    public void displayEmployees() {
        for (Employee e : employees) {
            System.out.println(e);
        }
    }
}


public class EmployeeManagementTest {
    public static void main(String[] args) {
        EmployeeManagement management = new EmployeeManagement();

        Employee emp1 = new Employee(1, "John Doe", "123 Elm St");
        Employee emp2 = new Employee(2, "Jane Smith", "456 Oak St");

        management.addEmployee(emp1);
        management.addEmployee(emp2);

        management.displayEmployees();

        management.updateEmployee(1, "789 Maple St");

        management.displayEmployees();

        management.removeEmployee(2);

        management.displayEmployees();
    }
}
