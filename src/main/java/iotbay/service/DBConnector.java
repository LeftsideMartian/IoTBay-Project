package iotbay.service;

import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Class for making a direct connection with the database
public class DBConnector {
    private Connection connection;

    public DBConnector() {
        try {
            // Get URL for the db
            String dbUrl = "jdbc:sqlite:" + getDbUrl();
            // Connect to db, and store connection
            this.connection = DriverManager.getConnection(dbUrl);
            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException sqlException) {
            System.out.println("There was a problem when connected to the database:\n" + sqlException.getMessage());
        }
    }

    // Get file location for the .db file
    private String getDbUrl() {
        String projectFolder = Paths.get("").toAbsolutePath().toString();
        System.out.println(projectFolder);
        return projectFolder + "\\src\\main\\db\\iotbay.db";
    }

    public Connection connect()  {
        return this.connection;
    }

    public void closeConnection() throws SQLException {
        this.connection.close();
    }
}