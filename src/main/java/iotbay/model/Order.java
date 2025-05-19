package iotbay.model;

import java.util.List;

public class Order {
    private int orderId;
    private int userId;
    private String deliveryAddress;
    private DeliveryStatus deliveryStatus;
    private String cardNumber;
    private List<Product> products;

    public Order(int orderId, int userId, String deliveryAddress, DeliveryStatus deliveryStatus, String cardNumber, List<Product> products) {
        this.orderId = orderId;
        this.userId = userId;
        this.deliveryAddress = deliveryAddress;
        this.deliveryStatus = deliveryStatus;
        this.cardNumber = cardNumber;
        this.products = products;
    }

    public int getOrderId() { return orderId; }
    public void setOrderId(int orderId) { this.orderId = orderId; }
    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }
    public String getDeliveryAddress() { return deliveryAddress; }
    public void setDeliveryAddress(String deliveryAddress) { this.deliveryAddress = deliveryAddress; }
    public String getDeliveryStatus() { return deliveryStatus.toString(); }
    public void setDeliveryStatus(DeliveryStatus deliveryStatus) { this.deliveryStatus = deliveryStatus; }
    public String getCardNumber() { return cardNumber; }
    public void setCardNumber(String cardNumber) { this.cardNumber = cardNumber; }
    public List<Product> getProducts() { return products; }
    public void setProducts(List<Product> products) { this.products = products; }

    // toString method for debugging
    @Override
    public String toString() {
        return
            "Order{" +
            "orderId=" + orderId +
            ", userId=" + userId +
            ", deliveryAddress='" + deliveryAddress + '\'' +
            ", deliveryStatus=" + deliveryStatus +
            ", cardNumber='" + cardNumber + '\'' +
            ", products=" + products +
            '}';
    }
}
