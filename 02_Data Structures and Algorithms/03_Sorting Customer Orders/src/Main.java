public class Main {
    public static void main(String[] args) {
        Order[] ordersForBubble = {
                new Order("O001", "Alice", 250.50),
                new Order("O002", "Bob", 12.00),
                new Order("O003", "Charlie", 890.00),
                new Order("O004", "David", 45.75)
        };

        Order[] ordersForQuick = ordersForBubble.clone();

        System.out.println("--- Before Bubble Sort ---");
        printOrders(ordersForBubble);

        OrderSorter.bubbleSort(ordersForBubble);

        System.out.println("\n--- After Bubble Sort ---");
        printOrders(ordersForBubble);

        System.out.println("\n--- Before Quick Sort ---");
        printOrders(ordersForQuick);

        OrderSorter.quickSort(ordersForQuick, 0, ordersForQuick.length - 1);

        System.out.println("\n--- After Quick Sort ---");
        printOrders(ordersForQuick);
    }

    private static void printOrders(Order[] orders) {
        for (Order order : orders) {
            System.out.println("ID: " + order.getOrderId() + " | Customer: " + order.getCustomerName() + " | Total: $" + order.getTotalPrice());
        }
    }
}