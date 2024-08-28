
import java.util.TreeSet;

public class UserRegistration {
    private TreeSet<String> users;

    public UserRegistration() {
        users = new TreeSet<>();
    }

    public void registerUser(String userName) {
        if (users.add(userName)) {
            System.out.println(userName + " registered successfully.");
        } else {
            System.out.println(userName + " is already registered.");
        }
    }

    public void removeUser(String userName) {
        if (users.remove(userName)) {
            System.out.println(userName + " removed successfully.");
        } else {
            System.out.println(userName + " not found.");
        }
    }

    public void displayUsers() {
        System.out.println("Registered Users: " + users);
    }
}

public class UserRegistrationTest {
    public static void main(String[] args) {
        UserRegistration registration = new UserRegistration();

        registration.registerUser("Alice");
        registration.registerUser("Bob");
        registration.registerUser("Charlie");

        registration.displayUsers();

        registration.removeUser("Bob");

        registration.displayUsers();
    }
}
