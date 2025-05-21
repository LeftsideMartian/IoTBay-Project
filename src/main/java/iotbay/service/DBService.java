package iotbay.service;

import iotbay.helper.ProjectConstants;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

/* 
DBService is an abstract class for service classes to extend from.
The service classes house the business logic for CRUD operations with a given table,
e.g. UserService, ProductService, OrderService perform CRUD operations on the User, Product and Order tables respectively

All of the CRUD operations follow the same pattern:
1. Fetch the SQL query from a .sql file using the getQueryFromFile() method
2. Create a PreparedStatement object
3. Set the parameters of the PreparedStatement
4. Execute the query
*/
abstract class DBService {
    protected Connection connection;

    // Constructor to store a connection object used for CRUD operations
    protected DBService(Connection connection) {
        this.connection = connection;
    }

    // Helper function to retrieve an SQL query from a .sql file, and return it as a string
    public String getQueryFromFile(String filename) {
        String windowsSlash = "\\";
        String macSlash = "/";
        String query = "";

        // Construct the file path for the SQL query in queryFileLocation
        String projectFolder = Paths.get("").toAbsolutePath() + "\\";

        String os = System.getProperty("os.name").split(" ")[0];

        if (os == "Windows") {
            projectFolder = projectFolder + windowsSlash;
        } else if (os == "Mac") {
            projectFolder = projectFolder + macSlash;
        }

        String queriesFolder = ProjectConstants.DB_QUERIES_FOLDER;
        String queryFileLocation = projectFolder + queriesFolder + filename;

        // Read the SQL query from the file
        try {
            Scanner queryScanner = new Scanner(new File(queryFileLocation));

            while (queryScanner.hasNextLine()) {
                query += queryScanner.nextLine() + "\n";
            }

            queryScanner.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return query.trim();
    }

    // Method to close the connection to the database
    public void closeConnection() {
        try {
            this.connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
