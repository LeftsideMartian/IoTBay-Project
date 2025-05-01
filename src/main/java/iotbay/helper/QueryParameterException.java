package iotbay.helper;

public class QueryParameterException extends RuntimeException {
    public QueryParameterException(String message) {
        super("There was an issue in the QueryReader class when setting a query parameter: " + message);
    }
}
