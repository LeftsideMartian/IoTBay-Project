package iotbay.service;

import iotbay.helper.QueryBuilder;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
* An abstract class for services to extend from
* */
abstract class DBService {
    protected Statement statement;
    protected QueryBuilder queryBuilder;

    /**
    * Constructor to establish a database connection using the DBConnector class
    * */
    protected DBService(Connection connection) {
        queryBuilder = new QueryBuilder();

        try {
            this.statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
