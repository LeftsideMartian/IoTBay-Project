package iotbay.model;

// Enum class representing the different statuses of an order delivery
public enum DeliveryStatus {
    IN_PROCESSING("In Progress"),
    ON_THE_WAY("On The Way"),
    DELIVERED("Delivered");

    final String deliveryStatus;

    DeliveryStatus(String deliveryStatus) { this.deliveryStatus = deliveryStatus; }

    // Getter method for the delivery status name
    @Override
    public String toString() { return this.deliveryStatus; }

    // Method to convert a string to a DeliveryStatus enum
    public static DeliveryStatus fromString(String text) {
        text = text.replaceAll(" ", "_");
        return DeliveryStatus.valueOf(text.toUpperCase());
    }
}
