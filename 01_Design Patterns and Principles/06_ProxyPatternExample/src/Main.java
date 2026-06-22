public class Main {
    public static void main(String[] args) {
        Image image = new ProxyImage("high_res_photo.jpg");

        System.out.println("--- First Display Call (Lazy Loading) ---");
        image.display();

        System.out.println("\n--- Second Display Call (Cached) ---");
        image.display();
    }
}