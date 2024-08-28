
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SalesAnalysis {
    public static void main(String[] args) {
        List<SalesRecord> records = Arrays.asList(
            new SalesRecord(1, "Alice", "North", 500.0, LocalDate.of(2024, 8, 1)),
            new SalesRecord(2, "Bob", "South", 300.0, LocalDate.of(2024, 8, 5)),
            new SalesRecord(3, "Charlie", "North", 700.0, LocalDate.of(2024, 8, 7)),
            new SalesRecord(4, "David", "East", 400.0, LocalDate.of(2024, 8, 10))
        );

        // Filter Sales Records
        List<SalesRecord> northRegionRecords = records.stream()
                .filter(record -> "North".equals(record.getRegion()))
                .collect(Collectors.toList());
        northRegionRecords.forEach(System.out::println);

        // Map and Transform Data
        List<Double> amounts = northRegionRecords.stream()
                .map(SalesRecord::getAmount)
                .collect(Collectors.toList());
        System.out.println("Sales Amounts: " + amounts);

        // Calculate Total Sales
        double totalSales = northRegionRecords.stream()
                .mapToDouble(SalesRecord::getAmount)
                .sum();
        System.out.println("Total Sales: " + totalSales);

        // Group Sales by SalesPerson
        records.stream()
                .collect(Collectors.groupingBy(SalesRecord::getSalesPerson))
                .forEach((salesPerson, recs) -> {
                    System.out.println("Sales Person: " + salesPerson);
                    recs.forEach(System.out::println);
                });

        // Generate Sales Report
        System.out.println("Sales Report:");
        records.stream()
                .collect(Collectors.groupingBy(SalesRecord::getSalesPerson,
                        Collectors.summingDouble(SalesRecord::getAmount)))
                .forEach((salesPerson, totalAmount) ->
                        System.out.println(salesPerson + ": " + totalAmount));
    }
}
