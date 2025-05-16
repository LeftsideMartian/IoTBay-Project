 package iotbay.test;

 import iotbay.dao.DBConnector;
 import iotbay.model.User;
 import iotbay.service.UserService;
 import org.junit.jupiter.api.DisplayName;
 import org.junit.jupiter.api.Test;
 import static org.junit.jupiter.api.Assertions.*;

 import java.sql.Connection;

 public class UserServiceTest {
     User testUser = new User(-1, "Test", "User", "testuser@test.com", "543210", false);
     DBConnector dbConnector = new DBConnector();
     Connection connection = dbConnector.connect();

     @Test
     @DisplayName("User Service - Get existing user")
     public void testExistingUser() {
         UserService userService = new UserService(connection);

         userService.createUser(testUser);

         User user = userService.getUser(testUser.getEmail(), testUser.getPassword());
         assertEquals(user.toString(), testUser.toString());
         userService.deleteUser(userService.getUser(testUser.getEmail(), testUser.getPassword()));
         userService.closeConnection();
     }

     @Test
     @DisplayName("User Service - Get non existent user")
     public void testNonExistentUser() {
         UserService userService = new UserService(connection);

         userService.deleteUser(userService.getUser(testUser.getEmail(), testUser.getPassword()));

         User user = userService.getUser(testUser.getEmail(), testUser.getPassword());
         assertNull(user);
         userService.deleteUser(userService.getUser(testUser.getEmail(), testUser.getPassword()));
         userService.closeConnection();
     }
 }