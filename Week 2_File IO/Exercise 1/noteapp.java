
import java.util.Scanner;

public class NoteApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FileWriterDemo writer = new FileWriterDemo();
        FileReaderDemo reader = new FileReaderDemo();

        System.out.print("Enter a note: ");
        String note = scanner.nextLine();

        String fileName = "note.txt";
        writer.saveNoteToFile(fileName, note);

        System.out.println("\nReading the note back from the file:");
        reader.readNoteFromFile(fileName);
    }
}
