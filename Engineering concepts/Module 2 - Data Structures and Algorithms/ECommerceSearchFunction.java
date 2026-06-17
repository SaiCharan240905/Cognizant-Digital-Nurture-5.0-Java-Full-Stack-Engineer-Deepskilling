import java.util.Arrays;
import java.util.Comparator;

// Product Class
class Product {

    private int productId;
    private String productName;
    private String category;

    public Product(int productId,
                   String productName,
                   String category) {

        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Product ID: " + productId +
               ", Product Name: " + productName +
               ", Category: " + category;
    }
}

// Main Class
public class ECommerceSearchFunction {

    // Linear Search
    public static Product linearSearch(
            Product[] products,
            String productName) {

        for (Product product : products) {

            if (product.getProductName()
                       .equalsIgnoreCase(productName)) {

                return product;
            }
        }

        return null;
    }

    // Binary Search
    public static Product binarySearch(
            Product[] products,
            String productName) {

        int left = 0;
        int right = products.length - 1;

        while (left <= right) {

            int mid = (left + right) / 2;

            int comparison =
                    products[mid]
                            .getProductName()
                            .compareToIgnoreCase(productName);

            if (comparison == 0) {
                return products[mid];
            }

            if (comparison < 0) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        return null;
    }

    // Display Products
    public static void displayProducts(Product[] products) {

        for (Product product : products) {
            System.out.println(product);
        }
    }

    public static void main(String[] args) {

        // Product Array for Linear Search
        Product[] products = {

                new Product(
                        101,
                        "Laptop",
                        "Electronics"),

                new Product(
                        102,
                        "Mouse",
                        "Accessories"),

                new Product(
                        103,
                        "Keyboard",
                        "Accessories"),

                new Product(
                        104,
                        "Mobile",
                        "Electronics"),

                new Product(
                        105,
                        "Tablet",
                        "Electronics")
        };

        System.out.println("Available Products:\n");
        displayProducts(products);

        // Linear Search
        System.out.println(
                "\n========== LINEAR SEARCH ==========");

        Product linearResult =
                linearSearch(products, "Mouse");

        if (linearResult != null) {

            System.out.println(
                    "\nProduct Found:");

            System.out.println(linearResult);
        }
        else {

            System.out.println(
                    "\nProduct Not Found");
        }

        // Create Sorted Array for Binary Search
        Product[] sortedProducts =
                products.clone();

        Arrays.sort(
                sortedProducts,
                Comparator.comparing(
                        Product::getProductName));

        System.out.println(
                "\n========== SORTED PRODUCTS ==========");

        displayProducts(sortedProducts);

        // Binary Search
        System.out.println(
                "\n========== BINARY SEARCH ==========");

        Product binaryResult =
                binarySearch(
                        sortedProducts,
                        "Mouse");

        if (binaryResult != null) {

            System.out.println(
                    "\nProduct Found:");

            System.out.println(binaryResult);
        }
        else {

            System.out.println(
                    "\nProduct Not Found");
        }
    }
}