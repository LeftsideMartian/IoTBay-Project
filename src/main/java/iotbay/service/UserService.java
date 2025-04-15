package iotbay.service;

import iotbay.model.User;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
* UserService is a service for dealing with the User table specifically
* */

public class UserService extends DBService {
    public UserService() {
        super(); //Super class will handle database connection
    }

    // Find a user based on an email and password
    public User findUser(String email, String password) {
        try {
            String queryString = getQueryFromFile("FindUser.sql");

            queryString = queryString.replaceAll("EMAIL", email);
            queryString = queryString.replaceAll("PASSWORD", password);

            ResultSet results = this.statement.executeQuery(queryString);

            return new User(
                results.getInt("User_ID"),
                results.getString("First_Name"),
                results.getString("Last_Name"),
                results.getString("Email"),
                results.getString("Password")
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Updates user at 'userId' based on the data in the newUser object
    public void updateUser(int userId, User newUser) {
        try {
            String queryString = getQueryFromFile("UpdateUser.sql");

            queryString = queryString.replaceAll("FIRSTNAME", newUser.firstName);
            queryString = queryString.replaceAll("LASTNAME", newUser.lastName);
            queryString = queryString.replaceAll("EMAIL", newUser.email);
            queryString = queryString.replaceAll("PASSWORD", newUser.password);
            queryString = queryString.replaceAll("USERID", String.valueOf(userId));

            this.statement.executeUpdate(queryString);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Delete the user at 'userid'
    public void deleteUser(int userId) {
        try {
            String queryString = getQueryFromFile("DeleteUser.sql");

            queryString = queryString.replaceAll("USERID", String.valueOf(userId));

            this.statement.executeUpdate(queryString);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
