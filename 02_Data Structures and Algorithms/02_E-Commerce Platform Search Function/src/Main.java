import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Product[] products = {
                new Product("P003", "Keyboard", "Electronics"),
                new Product("P001", "Laptop", "Electronics"),
                new Product("P002", "Mouse", "Electronics")
        };

        System.out.println("--- Testing Linear Search ---");
        Product result1 = SearchEngine.linearSearch(products, "P002");
        if (result1 != null) {
            System.out.println("Found: " + result1.getProductName());
        } else {
            System.out.println("Product not found.");
        }

        System.out.println("\n--- Testing Binary Search ---");
        Arrays.sort(products, Comparator.comparing(Product::getProductId));
        Product result2 = SearchEngine.binarySearch(products, "P002");
        if (result2 != null) {
            System.out.println("Found: " + result2.getProductName());
        } else {
            System.out.println("Product not found.");
        }
    }
}