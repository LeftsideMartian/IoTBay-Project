package iotbay.test;

import iotbay.dao.DBConnector;
import iotbay.model.User;
import iotbay.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {
    @Test
    @DisplayName("User Service - Find existing user")
    public void testExistingUser() {
        DBConnector dbConnector = new DBConnector();
        UserService userService = new UserService(dbConnector.connect());
        User testUser = new User(1, "Matthew", "Adler", "matt@a.com", "12345");

        User user = userService.findUser(testUser.getEmail(), testUser.getPassword());
        assertEquals(user.toString(), testUser.toString());
    }

    @Test
    @DisplayName("User Service - Find non existent user")
    public void testNonExistentUser() {
        DBConnector dbConnector = new DBConnector();
        UserService userService = new UserService(dbConnector.connect());
        User testUser = new User(-1, "asonfaosingoasn", "asginapsgnoansg", "asoginoasgbo", "aosginoasing");

        User user = userService.findUser(testUser.getEmail(), testUser.getPassword());
        assertEquals(user, null);
    }
}