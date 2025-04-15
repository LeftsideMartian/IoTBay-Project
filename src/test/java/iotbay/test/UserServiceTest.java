package iotbay.test;

import iotbay.model.User;
import iotbay.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {
    @Test
    @DisplayName("User Service - Test FindUser function")
    public void testFindUser() {
        UserService userService = new UserService();
        User testUser = new User(1, "Matthew", "Adler", "matt@a", "12345");

        User user = userService.findUser(testUser.email, testUser.password);
        assertEquals(user.toString(), testUser.toString());
    }
}