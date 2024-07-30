public class Computer {
    private String cpu;
    private int ram;
    private int storage;

    private Computer(Builder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
    }

    public static class Builder {
        private String cpu;
        private int ram;
        private int storage;
public Builder setCpu(String cpu) {
            this.cpu = cpu;
            return this;
        }

        public Builder setRam(int ram) {
            this.ram = ram;
            return this;
        }

        public Builder setStorage(int storage) {
            this.storage = storage;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}
public class ComputerBuilderTest {
    public static void main(String[] args) {
        Computer computer1 = new Computer.Builder()
                .setCpu("Intel i7")
                .setRam(16)
                .setStorage(512)
                .build();

        Computer computer2 = new Computer.Builder()
                .setCpu("AMD Ryzen 9")
                .setRam(32)
                .setStorage(1_000)
                .build();

    }
}