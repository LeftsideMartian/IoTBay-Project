-- Delete table if it already exists
DROP TABLE IF EXISTS User;

-- Create User table
CREATE TABLE User (
    User_Id INTEGER PRIMARY KEY AUTOINCREMENT,
    First_Name varchar(255) NOT NULL,
    Last_Name varchar(255) NOT NULL,
    Email varchar(255) NOT NULL,
    Password varchar(255) NOT NULL,
    Has_Admin_Permissions INTEGER NOT NULL
);

-- Insert default values into table
INSERT INTO User (First_Name, Last_Name, Email, Password, Has_Admin_Permissions) VALUES
('Matthew', 'Adler', 'matt@a.com', 'A12345#abcde', 0),
('Jahnavi', 'Nimboli', 'jahnavi@n.com', 'A12345#abcde', 0),
('Erin', 'Blanchard', 'erin@b.com', 'A12345#abcde', 0),
('Ambar', 'Sembhi', 'ambar@s.com', 'A12345#abcde', 0),
('Alysha', 'Desai', 'alysha@d.com', 'A12345#abcde', 0),
('Daniel', 'Keith', 'daniel@k.com', 'A12345#abcde', 0),
('Annabelle', 'Mansour', 'annabelle@m.com', 'A12345#abcde', 0),
('Alice', 'Smith', 'alice.smith@example.com', 'Password123!@#', 0),
('Bob', 'Johnson', 'bob.johnson@example.com', 'SecurePass1$', 0),
('Charlie', 'Brown', 'charlie.brown@example.com', 'Chocolate12$', 0),
('Diana', 'Prince', 'diana.prince@example.com', 'DianaRocks99!', 0),
('Ethan', 'Hunt', 'ethan.hunt@example.com', 'EthanMission1!', 0),
('Fiona', 'Gallagher', 'fiona.gallagher@example.com', 'FionaRules12$', 0),
('Grace', 'Lee', 'grace.lee@example.com', 'GracefulDay1!', 0),
('Henry', 'Ford', 'henry.ford@example.com', 'HenryBuilds2#', 0),
('Ivy', 'Nguyen', 'ivy.nguyen@example.com', 'IvyGarden34$', 0),
('Jack', 'Miller', 'jack.miller@example.com', 'JackAttack56!', 0),
('Karen', 'Baker', 'karen.baker@example.com', 'KarenBakes12$', 0),
('Liam', 'Turner', 'liam.turner@example.com', 'LiamTravels34!', 0),
('Admin', 'User', 'system@admin.iotbay', '', 1),
('Test', 'User', '1@2', '1', 1);