package iotbay.test;

import iotbay.dao.DBConnector;
import iotbay.model.User;
import iotbay.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {
    User testUser = new User(-1, "Test", "User", "testuser@test.com", "543210", false);

    @Test
    @DisplayName("User Service - Find existing user")
    public void testExistingUser() {
        DBConnector dbConnector = new DBConnector();
        UserService userService = new UserService(dbConnector.connect());

        userService.createUser(testUser);

        User user = userService.getUser(testUser.getEmail(), testUser.getPassword());
        assertEquals(user.toString(), testUser.toString());
        userService.closeConnection();
    }

    @Test
    @DisplayName("User Service - Find non existent user")
    public void testNonExistentUser() {
        DBConnector dbConnector = new DBConnector();
        UserService userService = new UserService(dbConnector.connect());

        userService.deleteUser(userService.getUser(testUser.getEmail(), testUser.getPassword()));

        User user = userService.getUser(testUser.getEmail(), testUser.getPassword());
        assertNull(user);
    }
}