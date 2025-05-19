-- Delete table if it already exists
DROP TABLE IF EXISTS Product;

-- Create Product table
CREATE TABLE Product (
    Product_Id INTEGER PRIMARY KEY AUTOINCREMENT,
    Product_Name varchar(255) NOT NULL,
    Description varchar(255) NOT NULL,
    Price DOUBLE NOT NULL,
    Stock_Quantity INTEGER NOT NULL,
    Category varchar(255) NOT NULL
);

-- Insert default values into table
INSERT INTO Product (Product_Name, Description, Price, Stock_Quantity, Category) VALUES
('Temperature Sensor', 'High-precision temperature sensor with digital output', 29.99, 100, 'Sensor'),
('Humidity Sensor', 'Wireless humidity sensor with battery backup', 34.50, 75, 'Sensor'),
('Motion Detector', 'PIR-based motion detector for indoor use', 19.95, 120, 'Sensor'),
('Water Leak Sensor', 'Wi-Fi water leak detector with mobile alerts', 24.99, 50, 'Sensor'),
('Air Quality Monitor', 'Detects PM2.5, VOCs, and CO2 levels with real-time feedback', 89.50, 30, 'Sensor'),
('Smart Light Bulb', 'Wi-Fi enabled smart bulb with adjustable brightness and color', 22.00, 60, 'Actuator'),
('Smart Plug', 'IoT-enabled smart plug with scheduling and monitoring features', 18.75, 80, 'Actuator'),
('Smart Thermostat', 'IoT-connected thermostat with learning capabilities', 139.00, 40, 'Actuator'),
('Smart Door Lock', 'Keyless smart lock with Bluetooth and keypad entry', 159.99, 20, 'Actuator'),
('Smart Curtain Motor', 'Automated curtain controller with app and voice support', 129.00, 15, 'Actuator'),
('LoRa Gateway', 'Long-range gateway for low-power IoT networks', 199.00, 15, 'Gateway'),
('Zigbee Coordinator', 'Central coordinator for Zigbee-based smart devices', 89.99, 25, 'Gateway'),
('Fitness Smartwatch', 'Fitness tracker with heart rate, sleep tracking, and GPS', 149.99, 45, 'Smart Watch'),
('Premium Smartwatch', 'Smartwatch with AMOLED display, NFC payments, and voice assistant', 249.99, 30, 'Smart Watch'),
('Kids Smartwatch', 'Child-friendly smartwatch with GPS and parental controls', 89.99, 20, 'Smart Watch'),
('Smart Security Camera', '1080p indoor/outdoor camera with night vision and cloud storage', 79.99, 35, 'Smart Home'),
('Smart Doorbell', 'Video doorbell with motion alerts and two-way audio', 99.50, 25, 'Smart Home'),
('Smart Speaker', 'Voice-controlled speaker with home automation integration', 59.99, 70, 'Smart Home'),
('Smart Camera', 'Indoor security camera with motion detection and cloud storage', 89.99, 40, 'Smart Home'),
('Smart Display Hub', 'Touchscreen smart hub for controlling IoT devices', 129.99, 18, 'Smart Home');