import java.util.Arrays;

class Product {
    private int productId;
    private String productName;
    private String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    // Getters and setters (omitted for brevity)

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}

public class InventorySearch {
    private Product[] products;

    public InventorySearch(Product[] products) {
        this.products = products;
        // Assuming products are sorted by product ID for binary search
        Arrays.sort(products, (p1, p2) -> Integer.compare(p1.getProductId(), p2.getProductId()));
    }

    // Linear search
    public Product linearSearch(int targetId) {
        for (Product product : products) {
            if (product.getProductId() == targetId) {
                return product;
            }
        }
        return null; // Not found
    }

    // Binary search
    public Product binarySearch(int targetId) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midId = products[mid].getProductId();

            if (midId == targetId) {
                return products[mid];
            } else if (midId < targetId) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null; // Not found
    }

    public static void main(String[] args) {
        Product[] sampleProducts = {
                new Product(101, "Widget A", "Electronics"),
                new Product(102, "Gizmo B", "Gadgets"),
                // Add more products as needed
        };

        InventorySearch inventory = new InventorySearch(sampleProducts);

        int targetProductId = 102;
        Product foundProduct = inventory.linearSearch(targetProductId);
        if (foundProduct != null) {
            System.out.println("Linear search result: " + foundProduct);
        } else {
            System.out.println("Product with ID " + targetProductId + " not found.");
        }

        foundProduct = inventory.binarySearch(targetProductId);
        if (foundProduct != null) {
            System.out.println("Binary search result: " + foundProduct);
        } else {
            System.out.println("Product with ID " + targetProductId + " not found.");
        }
    }
}
