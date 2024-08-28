import java.util.Scanner;

public class EmployeeManagementApp {
    public static void main(String[] args) {
        EmployeeDataRetrieval employeeData = new EmployeeDataRetrieval();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Add Employee");
            System.out.println("2. Update Employee");
            System.out.println("3. Delete Employee");
            System.out.println("4. View Employees");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.next();
                    System.out.print("Enter position: ");
                    String position = scanner.next();
                    System.out.print("Enter salary: ");
                    double salary = scanner.nextDouble();
                    employeeData.addEmployee(name, position, salary);
                    break;
                case 2:
                    System.out.print("Enter employee ID to update: ");
                    int updateId = scanner.nextInt();
                    System.out.print("Enter new name: ");
                    String newName = scanner.next();
                    System.out.print("Enter new position: ");
                    String newPosition = scanner.next();
                    System.out.print("Enter new salary: ");
                    double newSalary = scanner.nextDouble();
                    employeeData.updateEmployee(updateId, newName, newPosition, newSalary);
                    break;
                case 3:
                    System.out.print("Enter employee ID to delete: ");
                    int deleteId = scanner.nextInt();
                    employeeData.deleteEmployee(deleteId);
                    break;
                case 4:
                    employeeData.getEmployees();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
