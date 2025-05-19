-- Delete table if it already exists
DROP TABLE IF EXISTS Orders;

-- Create Orders table
CREATE TABLE Orders (
    Order_Id INTEGER PRIMARY KEY AUTOINCREMENT,
    User_Id INTEGER NOT NULL,
    Estimated_Delivery_Date varchar(255) NOT NULL,
    Delivery_Status varchar(255) NOT NULL,
    Log_Data varchar(255) NOT NULL,
    FOREIGN KEY (User_Id) REFERENCES User (User_Id)
);

-- Insert default values into table
INSERT INTO Orders (User_Id, Estimated_Delivery_Date, Delivery_Status, Log_Data) VALUES
(1, '2025-02-03', 'In Processing', 'Log data'),
(2, '2024-10-15', 'In Processing', 'Log data'),
(3, '2023-08-30', 'In Processing', 'Log data'),
(4, '2024-02-27', 'In Processing', 'Log data'),
(5, '2023-12-17', 'In Processing', 'Log data'),
(1, '2024-07-03', 'On The Way', 'Log data'),
(2, '2024-04-26', 'On The Way', 'Log data'),
(3, '2024-11-29', 'On The Way', 'Log data'),
(4, '2024-02-11', 'On The Way', 'Log data'),
(6, '2023-10-21', 'On The Way', 'Log data'),
(1, '2024-09-22', 'Delivered', 'Log data'),
(2, '2024-02-28', 'Delivered', 'Log data'),
(3, '2024-11-04', 'Delivered', 'Log data'),
(4, '2025-01-19', 'Delivered', 'Log data'),
(5, '2023-11-15', 'Delivered', 'Log data'),
(1, '2024-05-30', 'Delivered', 'Log data'),
(2, '2023-09-12', 'Delivered', 'Log data'),
(3, '2024-03-14', 'Delivered', 'Log data'),
(4, '2023-12-25', 'Delivered', 'Log data'),
(5, '2024-06-18', 'Delivered', 'Log data'),
(1, '2023-11-30', 'Delivered', 'Log data'),
(2, '2024-01-10', 'Delivered', 'Log data'),
(3, '2024-08-22', 'Delivered', 'Log data'),
(4, '2023-07-15', 'Delivered', 'Log data'),
(5, '2024-04-05', 'Delivered', 'Log data'),
(1, '2023-06-20', 'Delivered', 'Log data'),
(2, '2024-12-01', 'Delivered', 'Log data'),
(3, '2023-05-14', 'Delivered', 'Log data'),
(4, '2024-03-30', 'Delivered', 'Log data'),
(5, '2023-08-10', 'Delivered', 'Log data'),
(6, '2023-08-21', 'Delivered', 'Log data');