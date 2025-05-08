package iotbay.service;

import iotbay.helper.ProjectConstants;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.sql.Connection;
import java.util.Scanner;

/**
* An abstract class for services to extend from
* */
abstract class DBService {
    protected Connection connection;

    /**
    * Constructor to establish a database connection using the DBConnector class
    * */
    protected DBService(Connection connection) {
        this.connection = connection;
    }

    /**
     * Retrieve an SQL query from a .sql file and store it
     * @param filename The filename of the .sql file to retrieve
     * @return The query from the .sql file as a <i>newline</i> separated string
     * */
    public String getQueryFromFile(String filename) {
        String query = "";

        String projectFolder = Paths.get("").toAbsolutePath() + "\\";
        String queriesFolder = ProjectConstants.DB_QUERIES_FOLDER;
        String queryFileLocation = projectFolder + queriesFolder + filename;

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
}
