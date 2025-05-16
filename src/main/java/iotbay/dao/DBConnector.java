package iotbay.dao;

import iotbay.helper.ProjectConstants;

import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
* For making a direct connection with the database
* */
public class DBConnector {
    private final Connection connection;

    /**
    * Constructor to create a connection object with the SQLite database
    * */
    public DBConnector() {
        try {
            // Get URL for the db
            String dbUrl = ProjectConstants.JDBC_SQLITE_PREFIX + getDbUrl();
            // Connect to db, and store connection
            this.connection = DriverManager.getConnection(dbUrl);
            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e) {
            System.out.println("There was a problem when connecting to the database");
            throw new RuntimeException(e);
        }
    }

    /**
    * Get file location for the .db file
    * @return The file path for the project's SQLite .db file
    * */
    private String getDbUrl() {
        String projectFolder = Paths.get("").toAbsolutePath() + "\\";
        String dbFile = ProjectConstants.DB_FILE_LOCATION;
        return projectFolder + dbFile;
    }

    /**
    * Fetch the connection object for database interaction
    * */
    public Connection connect()  {
        return this.connection;
    }

    public void closeConnection() {
        try {
            this.connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}