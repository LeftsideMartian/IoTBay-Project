package iotbay.service;

import iotbay.helper.ProjectConstants;
import iotbay.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
        super(connection);
    }

    /**
    * Create a new user in the database
     * @param user The user object to create in the database
    * */
    public void createUser(User user) {
        String query = getQueryFromFile(ProjectConstants.USER_QUERY_CREATE);

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setBoolean(5, user.doesHaveAdminPermissions());

            preparedStatement.executeQuery();
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
    public User getUser(String email, String password) {
        String query = getQueryFromFile(ProjectConstants.USER_QUERY_GET);

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);

            ResultSet results = preparedStatement.executeQuery();

            if (results.next()) {
                return new User(
                    results.getInt(ProjectConstants.USER_COLUMN_USER_ID),
                    results.getString(ProjectConstants.USER_COLUMN_FIRST_NAME),
                    results.getString(ProjectConstants.USER_COLUMN_LAST_NAME),
                    results.getString(ProjectConstants.USER_COLUMN_EMAIL),
                    results.getString(ProjectConstants.USER_COLUMN_PASSWORD),
                    results.getBoolean(ProjectConstants.USER_COLUMN_HAS_ADMIN_PERMISSIONS)
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
        try {
            ResultSet results = connection.prepareStatement(getQueryFromFile(ProjectConstants.USER_QUERY_GET_ALL)).executeQuery();

            List<User> allUsers = new ArrayList<>();

            while (results.next()) {
                allUsers.add(new User(
                    results.getInt(ProjectConstants.USER_COLUMN_USER_ID),
                    results.getString(ProjectConstants.USER_COLUMN_FIRST_NAME),
                    results.getString(ProjectConstants.USER_COLUMN_LAST_NAME),
                    results.getString(ProjectConstants.USER_COLUMN_EMAIL),
                    results.getString(ProjectConstants.USER_COLUMN_PASSWORD),
                    results.getBoolean(ProjectConstants.USER_COLUMN_HAS_ADMIN_PERMISSIONS)
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
        String query = getQueryFromFile(ProjectConstants.USER_QUERY_UPDATE);

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, newUser.getFirstName());
            preparedStatement.setString(2, newUser.getLastName());
            preparedStatement.setString(3, newUser.getEmail());
            preparedStatement.setString(4, newUser.getPassword());
            preparedStatement.setBoolean(5, newUser.doesHaveAdminPermissions());
            preparedStatement.setString(6, String.valueOf(newUser.getUserId()));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
    * Delete the user at 'userid'
    * */
    public void deleteUser(User user) {
        String query = getQueryFromFile(ProjectConstants.USER_QUERY_DELETE);

        try {
            connection.prepareStatement(query).executeUpdate();
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
