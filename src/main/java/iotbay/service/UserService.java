package iotbay.service;

import iotbay.model.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

/**
* A service for dealing with the User table
* */
public class UserService extends DBService {
    /**
    * Public constructor calls super() to create a DB connection and get the Statement object used for executing queries
    * */
    public UserService() {
        super(); //Super class will handle database connection
    }

    /**
    * Create a new user in the database
     * @param user The user object to create in the database
    * */
    public void createUser(User user) {
        try {
            String queryString = getQueryFromFile("CreateUser.sql");

            queryString = queryString.replaceAll("FIRSTNAME", user.firstName);
            queryString = queryString.replaceAll("LASTNAME", user.lastName);
            queryString = queryString.replaceAll("EMAIL", user.email);
            queryString = queryString.replaceAll("PASSWORD", user.password);

            this.statement.executeUpdate(queryString);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Find a user based on an email and password
     * @param email An email to search for
     * @param password A password to search for
     * @return A user object from the database, or null if no data was found
     * */
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

    /**
    * Retrieve a list of all users in the database
    * @return A list of all users
    * */
    public List<User> getAllUsers() {
        try {
            String queryString = getQueryFromFile("GetAllUsers.sql");
            ResultSet results = this.statement.executeQuery(queryString);

            List<User> allUsers = new ArrayList<>();

            while (results.next()) {
                allUsers.add(new User(
                        results.getInt("User_ID"),
                        results.getString("First_Name"),
                        results.getString("Last_Name"),
                        results.getString("Email"),
                        results.getString("Password")
                ));
            }

            return allUsers;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
    * Updates user at 'userId'
    * @param userId The UserID to update in the database
    * @param newUser A user object containing the new data
    * */
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

    /**
    * Delete the user at 'userid'
    * @param userId The UserID to delete in the database
    * */
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
