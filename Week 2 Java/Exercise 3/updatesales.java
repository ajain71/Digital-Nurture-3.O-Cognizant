
import java.time.LocalDate;

public class SalesRecord {
    private int recordId;
    private String salesPerson;
    private String region;
    private double amount;
    private LocalDate date;
    private String productCategory;
    private int quantity;

    public SalesRecord(int recordId, String salesPerson, String region, double amount, LocalDate date, String productCategory, int quantity) {
        this.recordId = recordId;
        this.salesPerson = salesPerson;
        this.region = region;
        this.amount = amount;
        this.date = date;
        this.productCategory = productCategory;
        this.quantity = quantity;
    }

    // Getters and toString() remain unchanged
}
