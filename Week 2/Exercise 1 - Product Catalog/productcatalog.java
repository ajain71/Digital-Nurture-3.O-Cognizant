
import java.util.HashSet;

public class ProductCatalog {
    private HashSet<String> catalog;

    public ProductCatalog() {
        catalog = new HashSet<>();
    }

    public void addProduct(String productName) {
        if (catalog.add(productName)) {
            System.out.println(productName + " added to the catalog.");
        } else {
            System.out.println(productName + " is already in the catalog.");
        }
    }

    public void removeProduct(String productName) {
        if (catalog.remove(productName)) {
            System.out.println(productName + " removed from the catalog.");
        } else {
            System.out.println(productName + " not found in the catalog.");
        }
    }

    public boolean searchProduct(String productName) {
        return catalog.contains(productName);
    }

    public void displayProducts() {
        System.out.println("Product Catalog: " + catalog);
    }
}

public class ProductCatalogTest {
    public static void main(String[] args) {
        ProductCatalog catalog = new ProductCatalog();

        catalog.addProduct("Laptop");
        catalog.addProduct("Smartphone");
        catalog.addProduct("Tablet");
        
        catalog.displayProducts();

        catalog.removeProduct("Smartphone");

        catalog.displayProducts();

        System.out.println("Is 'Tablet' in the catalog? " + catalog.searchProduct("Tablet"));
    }
}
