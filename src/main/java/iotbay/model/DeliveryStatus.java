package iotbay.model;

public enum DeliveryStatus {
    IN_PROCESSING("In Progress"),
    ON_THE_WAY("On The Way"),
    DELIVERED("Delivered");

    final String deliveryStatus;

    DeliveryStatus(String deliveryStatus) { this.deliveryStatus = deliveryStatus; }

    @Override
    public String toString() { return this.deliveryStatus; }

    public static DeliveryStatus fromString(String text) {
        text = text.replaceAll(" ", "_");
        return DeliveryStatus.valueOf(text.toUpperCase());
    }
}
