
import java.util.ArrayList;
import java.util.List;

public class FileProcessorApp {
    public static void main(String[] args) {
        LargeFileReader reader = new LargeFileReader();
        LargeFileWriter writer = new LargeFileWriter();

        String inputFileName = "large_sales_data.txt";
        String outputFileName = "processed_sales_data.txt";

        System.out.println("Reading and processing the large file:");
        reader.readLargeFile(inputFileName);

        // Simulate processed data for demonstration purposes.
        List<String> processedData = new ArrayList<>();
        processedData.add("Processed Record 1");
        processedData.add("Processed Record 2");

        System.out.println("\nWriting the processed data to a new file:");
        writer.writeProcessedData(outputFileName, processedData);

        System.out.println("\nDemonstrating error handling by attempting to read a non-existent file:");
        reader.readLargeFile("non_existent_file.txt");
    }
}
