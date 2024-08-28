
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ContactReader {
    public Contact readContact(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (Contact) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("An error occurred while reading the contact: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Contact class not found: " + e.getMessage());
        }
        return null;
    }
}
