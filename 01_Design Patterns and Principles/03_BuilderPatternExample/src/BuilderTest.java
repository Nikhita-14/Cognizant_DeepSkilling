public class BuilderTest {
    public static void main(String[] args) {
        Computer officePC = new Computer.Builder("Intel i3", "8GB", "256GB SSD")
                .build();
        Computer gamingPC = new Computer.Builder("AMD Ryzen 9", "32GB", "2TB NVMe SSD")
                .setGraphicsCard(true)
                .setWiFi(true)
                .build();

        System.out.println("--- OFFICE PC ---");
        System.out.println(officePC);

        System.out.println("--- GAMING PC ---");
        System.out.println(gamingPC);
    }
}
