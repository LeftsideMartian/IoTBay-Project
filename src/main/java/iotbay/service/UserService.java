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
        queryBuilder.setAllUserParams(user);

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
                    results.getString("Password"),
                    results.getBoolean("Has_Admin_Permissions")
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

        try {
            ResultSet results = statement.executeQuery(queryBuilder.getQueryFromFile("GetAllUsers.sql"));

            List<User> allUsers = new ArrayList<>();

            while (results.next()) {
                allUsers.add(new User(
                    results.getInt("User_ID"),
                    results.getString("First_Name"),
                    results.getString("Last_Name"),
                    results.getString("Email"),
                    results.getString("Password"),
                    results.getBoolean("Has_Admin_Permissions")
                ));
            }

            return allUsers;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
    * Updates user at 'userId'
    * @param newUser A user object containing the new data
    * */
    public void updateUser(User newUser) {
        queryBuilder.clear();
        queryBuilder.getQueryFromFile("UpdateUser.sql");
        queryBuilder.setQueryParam("USERID", String.valueOf(newUser.getUserId()));
        queryBuilder.setAllUserParams(newUser);

        try {
            statement.executeUpdate(queryBuilder.getQuery());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
    * Delete the user at 'userid'
    * */
    public void deleteUser(User user) {
        queryBuilder.clear();
        queryBuilder.getQueryFromFile("DeleteUser.sql");

        queryBuilder.setQueryParam("USERID", String.valueOf(user.getUserId()));

        try {
            statement.executeUpdate(queryBuilder.getQuery());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isEmailInDatabase(String email) {
        List<User> userList = getAllUsers();

        for (User user : userList) {
            if (user.getEmail().equals(email)) return true;
        }

        return false;
    }
}
