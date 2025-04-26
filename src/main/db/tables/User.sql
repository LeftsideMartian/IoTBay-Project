-- Delete table if it already exists
DROP TABLE IF EXISTS User;

-- Create User table
CREATE TABLE User (
    User_Id INTEGER PRIMARY KEY AUTOINCREMENT,
    First_Name varchar(255) NOT NULL,
    Last_Name varchar(255) NOT NULL,
    Email varchar(255) NOT NULL,
    Password varchar(255) NOT NULL
);

-- Insert default values into table
INSERT INTO User (First_Name, Last_Name, Email, Password) VALUES
('Matthew', 'Adler', 'matt@a.com', 'A12345#abcde'),
('Jahnavi', 'Nimboli', 'jahnavi@n.com', 'A12345#abcde'),
('Erin', 'Blanchard', 'erin@b.com', 'A12345#abcde'),
('Ambar', 'Sembhi', 'ambar@s.com', 'A12345#abcde'),
('Alysha', 'Desai', 'alysha@d.com', 'A12345#abcde'),
('Annabelle', 'Mansour', 'annabelle@m.com', 'A12345#abcde'),
('Test', 'User', '1@2', '1');