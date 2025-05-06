package iotbay.controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.Arrays;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import iotbay.helper.ProjectConstants;
import iotbay.helper.Validator;
import iotbay.model.User;
import iotbay.service.UserService;

public class RegisterController extends HttpServlet {
    // Using the POST method for registering
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        Connection connection = (Connection) session.getAttribute(ProjectConstants.SESSION_ATTRIBUTE_DBCONNECTION);
        UserService userService = new UserService(connection);

        // Get form data
        String firstName = request.getParameter(ProjectConstants.REQUEST_ATTRIBUTE_USER_FIRST_NAME);
        String lastName = request.getParameter(ProjectConstants.REQUEST_ATTRIBUTE_USER_LAST_NAME);
        String email = request.getParameter(ProjectConstants.REQUEST_ATTRIBUTE_USER_EMAIL);
        String password = request.getParameter(ProjectConstants.REQUEST_ATTRIBUTE_USER_PASSWORD);
        boolean hasAdminPermissions = Boolean.parseBoolean(request.getParameter(ProjectConstants.REQUEST_ATTRIBUTE_USER_HAS_ADMIN_PERMISSIONS));

        User newUser = new User(-1, firstName, lastName, email, password, hasAdminPermissions);

        try {
            if (userService.isEmailInDatabase(email)) {
                // Send error message
                session.setAttribute(ProjectConstants.SESSION_ATTRIBUTE_REGISTER_ERROR, "Email is already registered.");
                response.sendRedirect(ProjectConstants.REGISTER_PAGE);
            } else if (Validator.isEmpty(firstName) || Validator.isEmpty(lastName)) {
                // Send error message
                session.setAttribute(ProjectConstants.SESSION_ATTRIBUTE_REGISTER_ERROR, "First or last name is missing.");
                response.sendRedirect(ProjectConstants.REGISTER_PAGE);
            } else if (!Validator.validateEmail(email)) {
                // Send error message
                session.setAttribute(ProjectConstants.SESSION_ATTRIBUTE_REGISTER_ERROR, "Invalid email.");
                response.sendRedirect(ProjectConstants.REGISTER_PAGE);
            } else if (!Validator.validatePassword(password)) {
                // Send error message
                session.setAttribute(ProjectConstants.SESSION_ATTRIBUTE_REGISTER_ERROR, "Invalid password.");
                response.sendRedirect(ProjectConstants.REGISTER_PAGE);
            } else {
                handleRegistration(newUser, userService, session, response);
            }
        } catch (IOException e) {
            System.out.println("Could not send redirect from RegisterController");
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }

    private void handleRegistration(User newUser, UserService userService, HttpSession session, HttpServletResponse response) {
        try {
            userService.createUser(newUser);
            session.setAttribute(ProjectConstants.SESSION_ATTRIBUTE_USER, newUser);
            response.sendRedirect(ProjectConstants.HOME_PAGE);
        } catch (IOException e) {
            System.out.println("Could not send redirect from RegisterController");
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }
}
