public class Main {
    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();

        manager.addProduct(new Product("P001", "Laptop", 10, 999.99));
        manager.addProduct(new Product("P002", "Mouse", 50, 24.99));

        manager.updateProduct("P001", 8, 949.99);
        manager.deleteProduct("P002");

        Product p = manager.getProduct("P001");
        if (p != null) {
            System.out.println("Product: " + p.getProductName() + ", Stock: " + p.getQuantity());
        }
    }
}