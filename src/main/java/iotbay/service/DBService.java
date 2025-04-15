package iotbay.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*
* An abstract class for services to extend from
* The DBService class provides:
* - Constructor to create connection to the database using the DBConnector class
* - Implementation of the getQueryFromFile method, which takes a filename and returns the .sql file as a string
* */

public abstract class DBService {
    protected DBConnector dbConnector;
    protected Connection connection;
    protected Statement statement;

    protected DBService() {
        try {
            this.dbConnector = new DBConnector();
            this.connection = this.dbConnector.connect();
            this.statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    protected String getQueryFromFile(String filename) {
        String query = "";

        String projectFolder = Paths.get("").toAbsolutePath().toString();
        String queryFile = projectFolder + "\\src\\main\\db\\queries\\" + filename;

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
