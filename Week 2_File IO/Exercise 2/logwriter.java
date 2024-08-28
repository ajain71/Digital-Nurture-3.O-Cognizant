
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class LogWriter {
    public void writeLog(String fileName, String logMessage) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(logMessage);
            writer.newLine();
            System.out.println("Log written to " + fileName);
        } catch (IOException e) {
            System.out.println("An error occurred while writing the log: " + e.getMessage());
        }
    }
}
