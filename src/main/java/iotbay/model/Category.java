package iotbay.model;

// Enum class representing the different categories of products
public enum Category {
    SENSOR("Sensor"),
    ACTUATOR("Actuator"),
    GATEWAY("Gateway"),
    SMART_WATCH("Smart Watch"),
    SMART_HOME("Smart Home");

    final String category;

    Category(String category) { this.category = category; }

    // Getter method for the category name
    @Override
    public String toString() { return this.category; }

    // Method to convert a string to a Category enum
    public static Category fromString(String text) {
        text = text.replaceAll(" ", "_");
        return Category.valueOf(text.toUpperCase());
    }
}
