public class Product {
    private final String productId;
    private final String productName;

    public Product(String productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
    }

    public String getProductId() { return productId; }
    public String getProductName() { return productName; }
}