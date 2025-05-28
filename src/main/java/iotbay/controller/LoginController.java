package iotbay.controller;

import iotbay.helper.ProjectConstants;
import iotbay.helper.Validator;
import iotbay.service.UserService;
import iotbay.model.User;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.util.Arrays;
import java.util.Objects;

// Controller class for the login.jsp page
public class LoginController extends HttpServlet {
    // Using the GET method for logging in
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        // Fetch session
        HttpSession session = request.getSession();

        // Get email and password from request data
        String email = request.getParameter(ProjectConstants.REQUEST_ATTRIBUTE_USER_EMAIL);
        String password = request.getParameter(ProjectConstants.REQUEST_ATTRIBUTE_USER_PASSWORD);

        // For testing purposes, skip data validation if the test user (1@2) is entered
        try {
            if (Objects.equals(email, "1@2")) {
                handleLogin(session, email, password, response);
            } else if (!Validator.validateEmail(email)) {
                // Send error message for invalid email
                session.setAttribute(ProjectConstants.SESSION_ATTRIBUTE_ERROR, "Invalid email.");
                response.sendRedirect(ProjectConstants.LOGIN_PAGE);
                return;
            } else {
                // Try to log in
                handleLogin(session, email, password, response);
            }
        } catch (IOException e) {
            System.out.println("Could not send redirect from LoginController");
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }

    // Method to handle login logic
    private void handleLogin(HttpSession session, String email, String password, HttpServletResponse response) throws IOException {
        // Fetch connection object from session and create a UserService instance
        Connection connection = (Connection) session.getAttribute(ProjectConstants.SESSION_ATTRIBUTE_DBCONNECTION);
        UserService userService = new UserService(connection);
        
        // Attempt to find the user in the database
        User user = userService.getUser(email, password);

        // If the user exists
        if (user != null) {
            // Store in session and redirect to home page
            session.setAttribute(ProjectConstants.SESSION_ATTRIBUTE_USER, user);
            response.sendRedirect(ProjectConstants.HOME_PAGE);
            return;
        } else {
            // Send error message for non-existent user
            session.setAttribute(ProjectConstants.SESSION_ATTRIBUTE_ERROR, "User does not exist in the database.");
            response.sendRedirect(ProjectConstants.LOGIN_PAGE);
            return;
        }
    }

    // Using the POST method for logging out
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            // Fetch session and remove user attribute, then redirect to home page
            HttpSession session = request.getSession();
            session.removeAttribute(ProjectConstants.SESSION_ATTRIBUTE_USER);
            response.sendRedirect(ProjectConstants.HOME_PAGE);
            return;
        } catch (IOException e) {
            System.out.println("Could not send redirect from LoginController");
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }
}
