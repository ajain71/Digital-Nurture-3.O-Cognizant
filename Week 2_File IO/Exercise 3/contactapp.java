
public class ContactApp {
    public static void main(String[] args) {
        ContactWriter writer = new ContactWriter();
        ContactReader reader = new ContactReader();

        Contact contact = new Contact("John Doe", "123-456-7890", "john@example.com");
        String fileName = "contact.ser";

        writer.saveContact(fileName, contact);

        System.out.println("\nReading the contact back from the file:");
        Contact savedContact = reader.readContact(fileName);
        if (savedContact != null) {
            System.out.println(savedContact);
        }

        System.out.println("\nAttempting to read from a non-existent file:");
        reader.readContact("non_existent_file.ser");
    }
}
