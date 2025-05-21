package iotbay.dao;

import iotbay.helper.ProjectConstants;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// For making a direct connection with the database
public class DBConnector {
    private final Connection connection;

    // Constructor to create a connection object with the SQLite database
    public DBConnector() {
        try {
            // Get URL for the database
            String dbUrl = ProjectConstants.JDBC_SQLITE_PREFIX + getDbUrl();
            // Connect to database, and store connection
            this.connection = DriverManager.getConnection(dbUrl);
            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e) {
            System.out.println("There was a problem when connecting to the database");
            throw new RuntimeException(e);
        }
    }

    // Get file location for the .db file
    private String getDbUrl() {
        String projectFolder = "";
        String dbFile = "";

        if (ProjectConstants.OS.equals("Windows")) {
            dbFile = ProjectConstants.WINDOWS_DB_FILE_LOCATION;
            projectFolder = Paths.get("").toAbsolutePath() + ProjectConstants.WINDOWS_SLASH;
        } else if (ProjectConstants.OS.equals("Mac")) {
            dbFile = ProjectConstants.MAC_DB_FILE_LOCATION;
            projectFolder = Paths.get("").toAbsolutePath() + ProjectConstants.MAC_SLASH;
        }

        return projectFolder + dbFile;
    }

    // Getter function for the connection object 
    public Connection connect()  {
        return this.connection;
    }

    // Close the connection to the database
    public void closeConnection() {
        try {
            this.connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}