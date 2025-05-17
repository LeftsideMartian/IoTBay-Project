package iotbay.service;

import iotbay.helper.ProjectConstants;
import iotbay.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// Service class for performing CRUD operations on the User table
public class UserService extends DBService {
    // Constructor simply calls super()
    public UserService(Connection connection) {
        super(connection);
    }

    // CRUD - Create
    public void createUser(User user) {
        String query = getQueryFromFile(ProjectConstants.USER_QUERY_CREATE);

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setBoolean(5, user.doesHaveAdminPermissions());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // CRUD - Read (Single user)
    public User getUser(String email, String password) {
        String query = getQueryFromFile(ProjectConstants.USER_QUERY_GET);

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);

            ResultSet results = preparedStatement.executeQuery();

            if (results.next()) {
                return getUserFromResultSet(results);
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // CRUD - Read (All users)
    public List<User> getAllUsers() {
        try {
            ResultSet results = connection.prepareStatement(getQueryFromFile(ProjectConstants.USER_QUERY_GET_ALL)).executeQuery();

            List<User> allUsers = new ArrayList<>();

            // Loop through the result set and add each user to the list
            while (results.next()) {
                allUsers.add(getUserFromResultSet(results));
            }

            return allUsers;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // CRUD - Update
    public void updateUser(User newUser) {
        String query = getQueryFromFile(ProjectConstants.USER_QUERY_UPDATE);

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, newUser.getFirstName());
            preparedStatement.setString(2, newUser.getLastName());
            preparedStatement.setString(3, newUser.getEmail());
            preparedStatement.setString(4, newUser.getPassword());
            // Note: User ID is an integer, no need to convert to String
            preparedStatement.setInt(5, newUser.getUserId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // CRUD - Delete
    public void deleteUser(User user) {
        if (user != null) {
            try {
                String query = getQueryFromFile(ProjectConstants.USER_QUERY_DELETE);
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, user.getUserId());

                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    // Helper function to convert a ResultSet row into a User object
    private User getUserFromResultSet(ResultSet resultSet) throws SQLException {
        return new User(
            resultSet.getInt(ProjectConstants.USER_COLUMN_USER_ID),
            resultSet.getString(ProjectConstants.USER_COLUMN_FIRST_NAME),
            resultSet.getString(ProjectConstants.USER_COLUMN_LAST_NAME),
            resultSet.getString(ProjectConstants.USER_COLUMN_EMAIL),
            resultSet.getString(ProjectConstants.USER_COLUMN_PASSWORD),
            resultSet.getBoolean(ProjectConstants.USER_COLUMN_HAS_ADMIN_PERMISSIONS)
        );
    }

    // Helper function to check if an email already exists in the database
    public boolean isEmailRegistered(String email) {
        List<User> userList = getAllUsers();

        for (User user : userList) {
            if (user.getEmail().equals(email)) return true;
        }

        return false;
    }
}
