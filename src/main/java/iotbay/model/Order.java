package iotbay.model;

import java.sql.Date;
import java.util.List;

public class Order {
    private int orderId;
    private int userId;
    private Date estimatedDeliveryDate;
    private DeliveryStatus deliveryStatus;
    private String logData;
    private List<Product> products;

    public Order(int orderId, int userId, Date estimatedDeliveryDate, DeliveryStatus deliveryStatus, String logData, List<Product> products) {
        this.orderId = orderId;
        this.userId = userId;
        this.estimatedDeliveryDate = estimatedDeliveryDate;
        this.deliveryStatus = deliveryStatus;
        this.logData = logData;
        this.products = products;
    }

    public int getOrderId() { return orderId; }
    public void setOrderId(int orderId) { this.orderId = orderId; }
    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }
    public Date getEstimatedDeliveryDate() { return estimatedDeliveryDate; }
    public void setEstimatedDeliveryDate(Date estimatedDeliveryDate) { this.estimatedDeliveryDate = estimatedDeliveryDate; }
    public String getDeliveryStatus() { return deliveryStatus.toString(); }
    public void setDeliveryStatus(DeliveryStatus deliveryStatus) { this.deliveryStatus = deliveryStatus; }
    public String getLogData() { return logData; }
    public void setLogData(String logData) { this.logData = logData; }
    public List<Product> getProducts() { return products; }
    public void setProducts(List<Product> products) { this.products = products; }

    // toString method for debugging
    @Override
    public String toString() {
        return
            "Order{" +
            "orderId=" + orderId +
            ", userId=" + userId +
            ", estimatedDeliveryDate=" + estimatedDeliveryDate +
            ", deliveryStatus=" + deliveryStatus +
            ", logData='" + logData + '\'' +
            ", products=" + products +
            '}';
    }
}
