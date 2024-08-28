
public class LogApp {
    public static void main(String[] args) {
        LogWriter writer = new LogWriter();
        LogReader reader = new LogReader();

        String fileName = "app_logs.txt";

        writer.writeLog(fileName, "Application started.");
        writer.writeLog(fileName, "User logged in.");
        writer.writeLog(fileName, "User performed an action.");

        System.out.println("\nReading logs:");
        reader.readLogs(fileName);

        System.out.println("\nAttempting to read from a non-existent file:");
        reader.readLogs("non_existent_file.txt");
    }
}
