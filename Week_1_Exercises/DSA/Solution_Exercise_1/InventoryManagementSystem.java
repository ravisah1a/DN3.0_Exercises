import java.util.HashMap;

class Product {
    private int productId;
    private String productName;
    private int quantity;
    private double price;

    public Product(int productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }


    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}

public class InventoryManagementSystem {
    private HashMap<Integer, Product> inventory;

    public InventoryManagementSystem() {
        inventory = new HashMap<>();
    }

    public void addProduct(Product product) {
        inventory.put(product.getProductId(), product);
    }

    public void updateProduct(int productId, Product updatedProduct) {
        if (inventory.containsKey(productId)) {
            inventory.put(productId, updatedProduct);
        } else {
            System.out.println("Product with ID " + productId + " not found.");
        }
    }

    public void deleteProduct(int productId) {
        inventory.remove(productId);
    }

    public Product getProduct(int productId) {
        return inventory.getOrDefault(productId, null);
    }

    public static void main(String[] args) {
        InventoryManagementSystem ims = new InventoryManagementSystem();

        Product p1 = new Product(101, "Widget A", 50, 19.99);
        Product p2 = new Product(102, "Gizmo B", 30, 29.99);

        ims.addProduct(p1);
        ims.addProduct(p2);

        System.out.println("Product with ID 101: " + ims.getProduct(101));
        System.out.println("Product with ID 102: " + ims.getProduct(102));

        p1.setQuantity(40);
        ims.updateProduct(101, p1);
        System.out.println("Updated product with ID 101: " + ims.getProduct(101));

        ims.deleteProduct(102);
        System.out.println("Product with ID 102 (after deletion): " + ims.getProduct(102));
    }
}
