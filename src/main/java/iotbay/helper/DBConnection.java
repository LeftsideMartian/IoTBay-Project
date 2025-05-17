package iotbay.helper;

import iotbay.dao.DBConnector;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Connection;

// Servlet for establishing a connection to the database
public class DBConnection extends HttpServlet {
    private DBConnector dbConnector;
    private Connection connection;

    // Initialise a connection to the database on load
    @Override
    public void init() {
        dbConnector = new DBConnector();
        connection = dbConnector.connect();
    }

    // Store the connection in session
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        session.setAttribute(ProjectConstants.SESSION_ATTRIBUTE_DBCONNECTION, connection);
    }

    // When servlet is destroyed, close the connection to the database
    @Override
    public void destroy() {
        dbConnector.closeConnection();
    }
}
