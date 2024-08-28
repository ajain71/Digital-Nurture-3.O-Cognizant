
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterDemo {
    public void saveNoteToFile(String fileName, String note) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(note);
            System.out.println("Note saved to " + fileName);
        } catch (IOException e) {
            System.out.println("An error occurred while saving the note: " + e.getMessage());
        }
    }
}
