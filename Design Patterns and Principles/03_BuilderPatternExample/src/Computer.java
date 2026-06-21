public class Computer {
    // 1. Attributes of a Computer
    private final String CPU;        // Required
    private final String RAM;        // Required
    private final String storage;    // Required
    private final boolean hasGraphicsCard; // Optional
    private final boolean hasWiFi;         // Optional

    // 4. Private constructor that takes the Builder as a parameter
    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
        this.hasGraphicsCard = builder.hasGraphicsCard;
        this.hasWiFi = builder.hasWiFi;
    }

    // Getters to read the data
    public String getCPU() { return CPU; }
    public String getRAM() { return RAM; }
    public String getStorage() { return storage; }
    public boolean isHasGraphicsCard() { return hasGraphicsCard; }
    public boolean isHasWiFi() { return hasWiFi; }

    @Override
    public String toString() {
        return "Computer Configuration:\n" +
                "- CPU: " + CPU + "\n" +
                "- RAM: " + RAM + "\n" +
                "- Storage: " + storage + "\n" +
                "- Dedicated Graphics: " + (hasGraphicsCard ? "Yes" : "No") + "\n" +
                "- Wi-Fi Card: " + (hasWiFi ? "Yes" : "No") + "\n";
    }

    // 3. Static nested Builder class
    public static class Builder {
        // Same attributes copied inside the builder
        private final String CPU;
        private final String RAM;
        private final String storage;
        private boolean hasGraphicsCard = false; // Default value
        private boolean hasWiFi = false;         // Default value

        // Constructor for the builder (forces user to provide required core parts)
        public Builder(String CPU, String RAM, String storage) {
            this.CPU = CPU;
            this.RAM = RAM;
            this.storage = storage;
        }

        // Setter for optional Graphics Card
        public Builder setGraphicsCard(boolean hasGraphicsCard) {
            this.hasGraphicsCard = hasGraphicsCard;
            return this; // Returns 'this' builder object to allow method chaining
        }

        // Setter for optional Wi-Fi
        public Builder setWiFi(boolean hasWiFi) {
            this.hasWiFi = hasWiFi;
            return this;
        }

        // The final build method that constructs the actual Computer
        public Computer build() {
            return new Computer(this);
        }
    }
}
