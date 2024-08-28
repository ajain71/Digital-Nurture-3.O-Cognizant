
import java.util.ArrayList;
import java.util.List;

public class OrderProcessing {
    public static void main(String[] args) {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order(1, "Alice", 250.0, "Pending"));
        orders.add(new Order(2, "Bob", 150.0, "Shipped"));
        orders.add(new Order(3, "Charlie", 300.0, "Pending"));

        // Lambda for filtering orders with amount greater than 200
        OrderFilter filter = order -> order.getOrderAmount() > 200;

        // Lambda for processing orders by changing status
        OrderProcessor processor = order -> order.setStatus("Processed");

        // Filter and process orders
        processOrders(orders, filter, processor);

        // Print orders after processing
        orders.forEach(System.out::println);
    }

    public static void processOrders(List<Order> orders, OrderFilter filter, OrderProcessor processor) {
        for (Order order : orders) {
            if (filter.filter(order)) {
                processor.process(order);
            }
        }
    }
}
