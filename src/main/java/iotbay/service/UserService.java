package iotbay.service;

import iotbay.model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* A service for dealing with the User table
* */
public class UserService extends DBService {
    /**
    * Public constructor calls super() to create a DB connection and get the Statement object used for executing queries
    * */
    public UserService(Connection connection) {
        super(connection); //Super class will create a statement object for queries
    }

    /**
    * Create a new user in the database
     * @param user The user object to create in the database
    * */
    public void createUser(User user) {
        queryBuilder.clear();
        queryBuilder.getQueryFromFile("CreateUser.sql");

        queryBuilder.setQueryParam("FIRSTNAME", user.getFirstName());
        queryBuilder.setQueryParam("LASTNAME", user.getLastName());
        queryBuilder.setQueryParam("EMAIL", user.getEmail());
        queryBuilder.setQueryParam("PASSWORD", user.getPassword());

        try {
            statement.executeUpdate(queryBuilder.getQuery());
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
        queryBuilder.clear();
        queryBuilder.getQueryFromFile("FindUser.sql");

        queryBuilder.setQueryParam("EMAIL", email);
        queryBuilder.setQueryParam("PASSWORD", password);

        try {
            ResultSet results = statement.executeQuery(queryBuilder.getQuery());

            if (results.next()) {
                return new User(
                    results.getInt("User_ID"),
                    results.getString("First_Name"),
                    results.getString("Last_Name"),
                    results.getString("Email"),
                    results.getString("Password")
                );
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
    * Retrieve a list of all users in the database
    * @return A list of all users
    * */
    public List<User> getAllUsers() {
        queryBuilder.clear();
        queryBuilder.getQueryFromFile("GetAllUsers.sql");

        try {
            ResultSet results = statement.executeQuery(queryBuilder.getQuery());

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
        queryBuilder.clear();
        queryBuilder.getQueryFromFile("UpdateUser.sql");

        queryBuilder.setQueryParam("FIRSTNAME", newUser.getFirstName());
        queryBuilder.setQueryParam("LASTNAME", newUser.getLastName());
        queryBuilder.setQueryParam("EMAIL", newUser.getEmail());
        queryBuilder.setQueryParam("PASSWORD", newUser.getPassword());
        queryBuilder.setQueryParam("USERID", String.valueOf(userId));

        try {
            statement.executeUpdate(queryBuilder.getQuery());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
    * Delete the user at 'userid'
    * @param userId The UserID to delete in the database
    * */
    public void deleteUser(int userId) {
        queryBuilder.clear();
        queryBuilder.getQueryFromFile("DeleteUser.sql");

        queryBuilder.setQueryParam("USERID", String.valueOf(userId));

        try {
            statement.executeUpdate(queryBuilder.getQuery());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
