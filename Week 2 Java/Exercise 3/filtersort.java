
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SalesAnalysis {
    public static void main(String[] args) {
        List<SalesRecord> records = Arrays.asList(
            new SalesRecord(1, "Alice", "North", 500.0, LocalDate.of(2024, 8, 1), "Electronics", 2),
            new SalesRecord(2, "Bob", "South", 300.0, LocalDate.of(2024, 8, 5), "Books", 5),
            new SalesRecord(3, "Charlie", "North", 700.0, LocalDate.of(2024, 8, 7), "Electronics", 1),
            new SalesRecord(4, "David", "East", 400.0, LocalDate.of(2024, 8, 10), "Books", 3)
        );

        // Filter and Sort Records
        List<SalesRecord> sortedRecords = records.stream()
                .filter(record -> "Electronics".equals(record.getProductCategory()))
                .sorted((r1, r2) -> r1.getDate().compareTo(r2.getDate()))
                .collect(Collectors.toList());
        sortedRecords.forEach(System.out::println);

        // Calculate Average Sales
        double averageSales = records.stream()
                .filter(record -> "North".equals(record.getRegion()))
                .mapToDouble(SalesRecord::getAmount)
                .average()
                .orElse(0);
        System.out.println("Average Sales in North: " + averageSales);

        // Find Top Sales Record
        SalesRecord topRecord = records.stream()
                .max((r1, r2) -> Double.compare(r1.getAmount(), r2.getAmount()))
                .orElse(null);
        System.out.println("Top Sales Record: " + topRecord);

        // Parallel Stream Operations
        long startTime = System.nanoTime();
        List<SalesRecord> parallelSortedRecords = records.parallelStream()
                .filter(record -> "Electronics".equals(record.getProductCategory()))
                .sorted((r1, r2) -> r1.getDate().compareTo(r2.getDate()))
                .collect(Collectors.toList());
        long endTime = System.nanoTime();
        System.out.println("Parallel sorting time: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        List<SalesRecord> sequentialSortedRecords = records.stream()
                .filter(record -> "Electronics".equals(record.getProductCategory()))
                .sorted((r1, r2) -> r1.getDate().compareTo(r2.getDate()))
                .collect(Collectors.toList());
        endTime = System.nanoTime();
        System.out.println("Sequential sorting time: " + (endTime - startTime) + " ns");
    }
}
