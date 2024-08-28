
public class Product {
    private int id;
    private String name;
    private int quantity;

    public Product(int id, String name, int quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int newQuantity) {
        this.quantity = newQuantity;
    }

    @Override
    public String toString() {
        return "Product ID: " + id + ", Name: " + name + ", Quantity: " + quantity;
    }
}

import java.util.HashMap;

public class InventoryManagement {
    private HashMap<Integer, Product> inventory;

    public InventoryManagement() {
        inventory = new HashMap<>();
    }

    public void addProduct(Product product) {
        inventory.put(product.getId(), product);
        System.out.println(product.getName() + " added to inventory.");
    }

    public void removeProduct(int productId) {
        Product removedProduct = inventory.remove(productId);
        if (removedProduct != null) {
            System.out.println("Product " + removedProduct.getName() + " removed from inventory.");
        } else {
            System.out.println("Product ID " + productId + " not found.");
        }
    }

    public void updateProductQuantity(int productId, int newQuantity) {
        Product product = inventory.get(productId);
        if (product != null) {
            product.setQuantity(newQuantity);
            System.out.println("Updated quantity for " + product.getName());
        } else {
            System.out.println("Product ID " + productId + " not found.");
        }
    }

    public void displayProducts() {
        for (Product product : inventory.values()) {
            System.out.println(product);
        }
    }
}

public class InventoryManagementTest {
    public static void main(String[] args) {
        InventoryManagement inventory = new InventoryManagement();

        Product product1 = new Product(1, "Laptop", 10);
        Product product2 = new Product(2, "Smartphone", 25);

        inventory.addProduct(product1);
        inventory.addProduct(product2);

        inventory.displayProducts();

        inventory.updateProductQuantity(1, 15);

        inventory.displayProducts();

        inventory.removeProduct(2);

        inventory.displayProducts();
    }
}
