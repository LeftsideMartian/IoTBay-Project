package iotbay.helper;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.Scanner;

import iotbay.model.User;

public class QueryBuilder {
    private String query;

    public QueryBuilder() {
        clear();
    }

    public void clear() {
        query = "";
    }

    /**
     * Retrieve an SQL query from a .sql file and store it
     * @param filename The filename of the .sql file to retrieve
     * @return The query from the .sql file as a <i>newline</i> separated string
     * */
    public String getQueryFromFile(String filename) {
        String projectFolder = Paths.get("").toAbsolutePath() + "\\";
        String queriesFolder = "src\\main\\db\\queries\\";
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

    public void setQueryParam(String param, String value) {
        try {
            String newQuery = query.replaceAll(param, value);
            if (newQuery.equals(query)) {
                throw new QueryParameterException("Parameter " + param + " was not found.");
            } else {
                query = newQuery;
            }
        } catch (QueryParameterException e) {
            throw new RuntimeException(e);
        }
    }

    public void setAllUserParams(User user) {
        setQueryParam("FIRSTNAME", user.getFirstName());
        setQueryParam("LASTNAME", user.getLastName());
        setQueryParam("EMAIL", user.getEmail());
        setQueryParam("PASSWORD", user.getPassword());
        setQueryParam("HASADMINPERMISSIONS", user.doesHaveAdminPermissions() ? "1" : "0");
    }

    public String getQuery() {
        return query;
    }
}
