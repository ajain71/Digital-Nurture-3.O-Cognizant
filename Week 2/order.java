
public class Order {
    private int orderId;
    private String orderDetails;

    public Order(int orderId, String orderDetails) {
        this.orderId = orderId;
        this.orderDetails = orderDetails;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getOrderDetails() {
        return orderDetails;
    }

    @Override
    public String toString() {
        return "Order ID: " + orderId + ", Details: " + orderDetails;
    }
}


import java.util.LinkedList;

public class OrderTracking {
    private LinkedList<Order> orders;

    public OrderTracking() {
        orders = new LinkedList<>();
    }

    public void addOrder(Order order) {
        orders.add(order);
        System.out.println("Order " + order.getOrderId() + " added.");
    }

    public Order processOrder() {
        Order order = orders.poll();
        if (order != null) {
            System.out.println("Processing Order: " + order);
        } else {
            System.out.println("No orders to process.");
        }
        return order;
    }

    public void displayOrders() {
        System.out.println("Current Orders: " + orders);
    }
}


public class OrderTrackingTest {
    public static void main(String[] args) {
        OrderTracking tracking = new OrderTracking();

        Order order1 = new Order(1, "Pizza");
        Order order2 = new Order(2, "Burger");
        Order order3 = new Order(3, "Pasta");

        tracking.addOrder(order1);
        tracking.addOrder(order2);
        tracking.addOrder(order3);

        tracking.displayOrders();

        tracking.processOrder();

        tracking.displayOrders();
    }
}
