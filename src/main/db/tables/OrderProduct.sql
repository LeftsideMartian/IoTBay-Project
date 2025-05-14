-- Delete table if it already exists
DROP TABLE IF EXISTS OrderProduct;

-- Create User table
CREATE TABLE OrderProduct (
    Order_Id INTEGER NOT NULL,
    Product_Id INTEGER NOT NULL,
    Quantity INTEGER NOT NULL,
    PRIMARY KEY (Order_Id, Product_Id),
    FOREIGN KEY (Order_Id) REFERENCES Orders (Order_Id),
    FOREIGN KEY (Product_Id) REFERENCES Product (Product_Id)
);

-- Insert default values into table
INSERT INTO OrderProduct (Order_Id, Product_Id, Quantity) VALUES
(1, 1, 2),
(1, 2, 2),
(2, 3, 2),
(2, 4, 2),
(3, 5, 2),
(3, 6, 2),
(4, 7, 2),
(4, 8, 2),
(5, 9, 2),
(5, 10, 2),
(6, 11, 2),
(6, 12, 2),
(7, 13, 2),
(7, 14, 2),
(8, 15, 2),
(8, 16, 2),
(9, 17, 2),
(9, 18, 2),
(10, 19, 2),
(10, 11, 2),
(11, 1, 2),
(11, 2, 2),
(12, 3, 2),
(12, 4, 2),
(13, 5, 2),
(13, 6, 2),
(14, 7, 2),
(14, 8, 2),
(15, 9, 2),
(15, 10, 2);