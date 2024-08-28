
public class Contact {
    private int id;
    private String name;
    private String phoneNumber;

    public Contact(int id, String name, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "Contact ID: " + id + ", Name: " + name + ", Phone Number: " + phoneNumber;
    }
}

// ContactManagement.java
import java.util.Hashtable;

public class ContactManagement {
    private Hashtable<Integer, Contact> contacts;

    public ContactManagement() {
        contacts = new Hashtable<>();
    }

    public void addContact(Contact contact) {
        contacts.put(contact.getId(), contact);
        System.out.println("Contact " + contact.getName() + " added.");
    }

    public void removeContact(int contactId) {
        Contact removedContact = contacts.remove(contactId);
        if (removedContact != null) {
            System.out.println("Contact " + removedContact.getName() + " removed.");
        } else {
            System.out.println("Contact ID " + contactId + " not found.");
        }
    }

    public void displayContacts() {
        for (Contact contact : contacts.values()) {
            System.out.println(contact);
        }
    }
}

// ContactManagementTest
public class ContactManagementTest {
    public static void main(String[] args) {
        ContactManagement management = new ContactManagement();

        Contact contact1 = new Contact(1, "John Doe", "123-456-7890");
        Contact contact2 = new Contact(2, "Jane Smith", "987-654-3210");

        management.addContact(contact1);
        management.addContact(contact2);

        management.displayContacts();

        management.removeContact(1);

        management.displayContacts();
    }
}
