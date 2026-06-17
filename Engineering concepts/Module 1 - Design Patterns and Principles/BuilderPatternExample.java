// Product Class
class Computer {

    // Attributes
    private String cpu;
    private String ram;
    private String storage;
    private String graphicsCard;
    private String operatingSystem;

    // Private Constructor
    private Computer(Builder builder) {

        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
        this.graphicsCard = builder.graphicsCard;
        this.operatingSystem = builder.operatingSystem;
    }

    // Display Configuration
    public void displayConfiguration() {

        System.out.println("Computer Configuration:");

        System.out.println("CPU              : " + cpu);
        System.out.println("RAM              : " + ram);
        System.out.println("Storage          : " + storage);
        System.out.println("Graphics Card    : " + graphicsCard);
        System.out.println("Operating System : " + operatingSystem);

        System.out.println();
    }

    // Static Nested Builder Class
    public static class Builder {

        private String cpu;
        private String ram;
        private String storage;
        private String graphicsCard;
        private String operatingSystem;

        // Setter Methods
        public Builder setCPU(String cpu) {
            this.cpu = cpu;
            return this;
        }

        public Builder setRAM(String ram) {
            this.ram = ram;
            return this;
        }

        public Builder setStorage(String storage) {
            this.storage = storage;
            return this;
        }

        public Builder setGraphicsCard(String graphicsCard) {
            this.graphicsCard = graphicsCard;
            return this;
        }

        public Builder setOperatingSystem(String operatingSystem) {
            this.operatingSystem = operatingSystem;
            return this;
        }

        // Build Method
        public Computer build() {
            return new Computer(this);
        }
    }
}

// Main Test Class
public class BuilderPatternExample {

    public static void main(String[] args) {

        System.out.println(
                "===== Builder Pattern Demo =====\n");

        // Gaming Computer
        Computer gamingPC =
                new Computer.Builder()
                        .setCPU("Intel Core i9")
                        .setRAM("32GB")
                        .setStorage("1TB SSD")
                        .setGraphicsCard("NVIDIA RTX 4090")
                        .setOperatingSystem("Windows 11")
                        .build();

        gamingPC.displayConfiguration();

        // Office Computer
        Computer officePC =
                new Computer.Builder()
                        .setCPU("Intel Core i5")
                        .setRAM("16GB")
                        .setStorage("512GB SSD")
                        .setOperatingSystem("Windows 10")
                        .build();

        officePC.displayConfiguration();

        // Student Computer
        Computer studentPC =
                new Computer.Builder()
                        .setCPU("AMD Ryzen 5")
                        .setRAM("8GB")
                        .setStorage("256GB SSD")
                        .build();

        studentPC.displayConfiguration();
    }
}