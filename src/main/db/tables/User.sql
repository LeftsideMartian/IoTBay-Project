-- Delete table if it already exists
DROP TABLE User;

-- Create User table
CREATE TABLE User (
    User_Id INT NOT NULL,
    First_Name varchar(255) NOT NULL,
    Last_Name varchar(255) NOT NULL,
    Email varchar(255) NOT NULL,
    Password varchar(255) NOT NULL,
    PRIMARY KEY (User_Id)
);

-- Insert default values into table
INSERT INTO User (User_Id, First_Name, Last_Name, Email, Password) VALUES
(1, "Matthew", "Adler", "matt@a", "12345"),
(2, "Jahnavi", "Nimboli", "jahnavi@n", "12345"),
(3, "Erin", "Blanchard", "erin@b", "12345"),
(4, "Ambar", "Sembhi", "ambar@s", "12345"),
(5, "Alysha", "Desai", "alysha@d", "12345"),
(6, "Annabelle", "Mansour", "annabelle@m", "12345");