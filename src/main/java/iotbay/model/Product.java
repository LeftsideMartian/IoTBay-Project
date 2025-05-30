package iotbay.model;

import java.io.Serializable;

// Model class for products
public class Product implements Serializable {
    private int productId;
    private String productName;
    private String description;
    private double price;
    private int quantity;
    private Category category;

    // All args constructor
    public Product(int productId, String productName, String description, double price, int quantity, Category category) {
        this.productId = productId;
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }

    // Getter and setter methods
    public int getProductId() { return productId; }
    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }

    // toString method for debugging
    @Override
    public String toString() {
        return
            "Product {" +
            "productName='" + productName + '\'' +
            ", description='" + description + '\'' +
            ", price=" + price +
            ", quantity=" + quantity +
            ", category=" + category +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        return o.toString().equals(this.toString());
    }
}
