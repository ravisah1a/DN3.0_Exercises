class Order {
    private int orderId;
    private String customerName;
    private double totalPrice;

    // Constructors, getters, setters (omitted for brevity)
}

public class OrderSorting {
    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].getTotalPrice() > orders[j + 1].getTotalPrice()) {
                    // Swap
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }

    // Implement Quick Sort 

    public static void main(String[] args) {
        // Create some sample orders
        Order[] orders = {
                new Order(101, "Alice", 150.0),
                new Order(102, "Bob", 120.0),
                // Add more orders as needed
        };

        bubbleSort(orders);

        // Print sorted orders
        for (Order order : orders) {
            System.out.println(order.getOrderId() + ": " + order.getCustomerName() + " ($" + order.getTotalPrice() + ")");
        }
    }
}
