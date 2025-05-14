package iotbay.model;

import java.io.Serializable;

public class Product implements Serializable {
    private int productId;
    private String productName;
    private String description;
    private double price;
    private int stockQuantity;
    private Category category;

    public Product(int productId, String productName, String description, double price, int stockQuantity, Category category) {
        this.productId = productId;
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.category = category;
    }

    public int getProductId() { return productId; }
    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public int getStockQuantity() { return stockQuantity; }
    public void setStockQuantity(int stockQuantity) { this.stockQuantity = stockQuantity; }
    public String getCategory() { return category.toString(); }
    public void setCategory(Category category) { this.category = category; }

    @Override
    public String toString() {
        return
            "Product {" +
            "productName='" + productName + '\'' +
            ", description='" + description + '\'' +
            ", price=" + price +
            ", stockQuantity=" + stockQuantity +
            ", category=" + category +
            '}';
    }
}
