// Order Class
class Order {

    private int orderId;
    private String customerName;
    private double totalPrice;

    public Order(int orderId,
                 String customerName,
                 double totalPrice) {

        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    @Override
    public String toString() {

        return "Order ID: " + orderId +
                ", Customer: " + customerName +
                ", Total Price: ₹" + totalPrice;
    }
}

public class CustomerOrderSorting {

    // Bubble Sort
    public static void bubbleSort(Order[] orders) {

        int n = orders.length;

        for (int i = 0; i < n - 1; i++) {

            boolean swapped = false;

            for (int j = 0; j < n - i - 1; j++) {

                if (orders[j].getTotalPrice() >
                        orders[j + 1].getTotalPrice()) {

                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;

                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }
    }

    // Quick Sort
    public static void quickSort(Order[] orders,
                                 int low,
                                 int high) {

        if (low < high) {

            int pivotIndex =
                    partition(orders, low, high);

            quickSort(orders,
                    low,
                    pivotIndex - 1);

            quickSort(orders,
                    pivotIndex + 1,
                    high);
        }
    }

    private static int partition(Order[] orders,
                                 int low,
                                 int high) {

        double pivot =
                orders[high].getTotalPrice();

        int i = low - 1;

        for (int j = low; j < high; j++) {

            if (orders[j].getTotalPrice() < pivot) {

                i++;

                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }

        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;

        return i + 1;
    }

    // Display Orders
    public static void displayOrders(Order[] orders) {

        for (Order order : orders) {
            System.out.println(order);
        }
    }

    public static void main(String[] args) {

        Order[] orders = {

                new Order(
                        101,
                        "Sai",
                        2500),

                new Order(
                        102,
                        "Rahul",
                        1200),

                new Order(
                        103,
                        "Priya",
                        4500),

                new Order(
                        104,
                        "Anjali",
                        1800),

                new Order(
                        105,
                        "Kiran",
                        3200)
        };

        System.out.println(
                "========== ORIGINAL ORDERS ==========\n");

        displayOrders(orders);

        // Bubble Sort
        Order[] bubbleOrders = orders.clone();

        bubbleSort(bubbleOrders);

        System.out.println(
                "\n========== AFTER BUBBLE SORT ==========\n");

        displayOrders(bubbleOrders);

        // Quick Sort
        Order[] quickOrders = orders.clone();

        quickSort(
                quickOrders,
                0,
                quickOrders.length - 1);

        System.out.println(
                "\n========== AFTER QUICK SORT ==========\n");

        displayOrders(quickOrders);
    }
}