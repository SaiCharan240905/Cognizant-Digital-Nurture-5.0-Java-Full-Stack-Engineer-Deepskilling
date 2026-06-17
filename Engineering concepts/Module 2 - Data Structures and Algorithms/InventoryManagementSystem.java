import java.util.HashMap;
import java.util.Map;

// Product Class
class Product {

    private int productId;
    private String productName;
    private int quantity;
    private double price;

    public Product(int productId,
                   String productName,
                   int quantity,
                   double price) {

        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product ID: " + productId +
               ", Name: " + productName +
               ", Quantity: " + quantity +
               ", Price: ₹" + price;
    }
}

// Inventory Manager Class
class InventoryManager {

    private HashMap<Integer, Product> inventory;

    public InventoryManager() {
        inventory = new HashMap<>();
    }

    // Add Product
    public void addProduct(Product product) {

        if (inventory.containsKey(product.getProductId())) {

            System.out.println(
                    "Product with ID "
                    + product.getProductId()
                    + " already exists.");

            return;
        }

        inventory.put(product.getProductId(), product);

        System.out.println(
                "Product Added Successfully.");
    }

    // Update Product
    public void updateProduct(int productId,
                              String newName,
                              int newQuantity,
                              double newPrice) {

        Product product = inventory.get(productId);

        if (product == null) {

            System.out.println(
                    "Product Not Found.");

            return;
        }

        product.setProductName(newName);
        product.setQuantity(newQuantity);
        product.setPrice(newPrice);

        System.out.println(
                "Product Updated Successfully.");
    }

    // Delete Product
    public void deleteProduct(int productId) {

        if (inventory.remove(productId) != null) {

            System.out.println(
                    "Product Deleted Successfully.");
        }
        else {

            System.out.println(
                    "Product Not Found.");
        }
    }

    // Display Inventory
    public void displayInventory() {

        if (inventory.isEmpty()) {

            System.out.println(
                    "Inventory is Empty.");

            return;
        }

        System.out.println("\nInventory Details");

        for (Map.Entry<Integer, Product> entry :
                inventory.entrySet()) {

            System.out.println(entry.getValue());
        }
    }
}

// Main Class
public class InventoryManagementSystem {

    public static void main(String[] args) {

        InventoryManager manager =
                new InventoryManager();

        // Add Products
        Product p1 =
                new Product(
                        101,
                        "Laptop",
                        10,
                        55000);

        Product p2 =
                new Product(
                        102,
                        "Mouse",
                        50,
                        750);

        Product p3 =
                new Product(
                        103,
                        "Keyboard",
                        30,
                        1500);

        manager.addProduct(p1);
        manager.addProduct(p2);
        manager.addProduct(p3);

        // Display Products
        manager.displayInventory();

        // Update Product
        System.out.println(
                "\nUpdating Product 102...\n");

        manager.updateProduct(
                102,
                "Wireless Mouse",
                45,
                1000);

        manager.displayInventory();

        // Delete Product
        System.out.println(
                "\nDeleting Product 103...\n");

        manager.deleteProduct(103);

        manager.displayInventory();
    }
}