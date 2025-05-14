package iotbay.model;

public enum Category {
    SENSOR("Sensor"),
    ACTUATOR("Actuator"),
    GATEWAY("Gateway"),
    SMART_WATCH("Smart Watch"),
    SMART_HOME("Smart Home");

    final String category;

    Category(String category) { this.category = category; }

    @Override
    public String toString() { return this.category; }

    public static Category fromString(String text) {
        text = text.replaceAll(" ", "_");
        return Category.valueOf(text.toUpperCase());
    }
}
