 package iotbay.test;

 import iotbay.dao.DBConnector;
 import iotbay.model.User;
 import iotbay.service.UserService;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
 import org.junit.jupiter.api.Test;
 import static org.junit.jupiter.api.Assertions.*;

 import java.sql.Connection;

 public class UserServiceTest {
    DBConnector dbConnector;
    Connection connection;
    UserService userService;
    User testUser = new User(-1, "Test", "User", "testuser@test.com", "543210", false);
        
    @BeforeEach
    public void getConnection() {
        dbConnector = new DBConnector();
        connection = dbConnector.connect();
        userService = new UserService(connection);
    }

    @AfterEach
    public void closeConnection() {
        dbConnector.closeConnection();
    }

    @Test
    @DisplayName("User Service - Get existing user")
    public void testExistingUser() {
        userService.createUser(testUser);

        User user = userService.getUser(testUser.getEmail(), testUser.getPassword());
        assertEquals(user.toString(), testUser.toString());
        userService.deleteUser(userService.getUser(testUser.getEmail(), testUser.getPassword()));
    }

    @Test
    @DisplayName("User Service - Get non existent user")
    public void testNonExistentUser() {
        // Ensure user does not exist in the database
        User userToDelete = userService.getUser(testUser.getEmail(), testUser.getPassword());

        if (userToDelete != null) {
            userService.deleteUser(userToDelete);
        }

        // Check if user exists in the database with getUser method
        User user = userService.getUser(testUser.getEmail(), testUser.getPassword());
        assertNull(user);
    }
 }