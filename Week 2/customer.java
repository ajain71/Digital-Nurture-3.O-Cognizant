
public class Customer {
    private int id;
    private String name;
    private String email;

    public Customer(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Customer ID: " + id + ", Name: " + name + ", Email: " + email;
    }
}

import java.util.TreeMap;

public class CustomerAccounts {
    private TreeMap<Integer, Customer> accounts;

    public CustomerAccounts() {
        accounts = new TreeMap<>();
    }

    public void addCustomer(Customer customer) {
        accounts.put(customer.getId(), customer);
        System.out.println("Customer " + customer.getName() + " added.");
    }

    public void removeCustomer(int customerId) {
        Customer removedCustomer = accounts.remove(customerId);
        if (removedCustomer != null) {
            System.out.println("Customer " + removedCustomer.getName() + " removed.");
        } else {
            System.out.println("Customer ID " + customerId + " not found.");
        }
    }

    public void displayCustomers() {
        for (Customer customer : accounts.values()) {
            System.out.println(customer);
        }
    }
}

// CustomerAccountsTest.java
public class CustomerAccountsTest {
    public static void main(String[] args) {
        CustomerAccounts accounts = new CustomerAccounts();

        Customer customer1 = new Customer(101, "John Doe", "john@example.com");
        Customer customer2 = new Customer(102, "Jane Smith", "jane@example.com");

        accounts.addCustomer(customer1);
        accounts.addCustomer(customer2);

        accounts.displayCustomers();

        accounts.removeCustomer(101);

        accounts.displayCustomers();
    }
}
