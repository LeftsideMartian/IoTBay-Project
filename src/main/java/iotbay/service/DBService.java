package iotbay.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
* An abstract class for services to extend from
* */
abstract class DBService {
    protected DBConnector dbConnector;
    protected Connection connection;
    protected Statement statement;

    /**
    * Constructor to establish a database connection using the DBConnector class
    * */
    protected DBService() {
        try {
            this.dbConnector = new DBConnector();
            this.connection = this.dbConnector.connect();
            this.statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
    * Retrieve an SQL query from a .sql file
    * @param filename The filename of the .sql file to retrieve
    * @return The query from the .sql file as a <i>newline</i> separated string
    * */
    protected String getQueryFromFile(String filename) {
        String query = "";

        String projectFolder = Paths.get("").toAbsolutePath().toString() + "\\";
        String queriesFolder = "src\\main\\db\\queries\\";
        String queryFile = projectFolder + queriesFolder + filename;

        try {
            Scanner queryScanner = new Scanner(new File(queryFile));
            while (queryScanner.hasNextLine()) {
                query += queryScanner.nextLine() + "\n";
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return query.trim();
    }
}
