package iotbay.controller;

import java.io.IOException;
import java.sql.Connection;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import iotbay.helper.Validator;
import iotbay.model.User;
import iotbay.service.UserService;

public class RegisterController extends HttpServlet {
    // Using the POST method for registering
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        Connection connection = (Connection) session.getAttribute("dbConnection");
        UserService userService = new UserService(connection);

        // Get form data
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        boolean hasAdminPermissions = Boolean.parseBoolean(request.getParameter("hasAdminPermissions"));

        User newUser = new User(-1, firstName, lastName, email, password, hasAdminPermissions);

        if (userService.isEmailInDatabase(email)) {
            // Send error message
            session.setAttribute("registerError", "Email is already registered.");
            response.sendRedirect("/register.jsp");
        } else if (Validator.isEmpty(firstName) || Validator.isEmpty(lastName)) {
            // Send error message
            session.setAttribute("registerError", "First or last name is missing.");
            response.sendRedirect("/register.jsp");
        } else if (!Validator.validateEmail(email)) {
            // Send error message
            session.setAttribute("registerError", "Invalid email.");
            response.sendRedirect("/register.jsp");
        } else if (!Validator.validatePassword(password)) {
            // Send error message
            session.setAttribute("registerError", "Invalid password.");
            response.sendRedirect("/register.jsp");
        } else {
            handleRegistration(newUser, userService, session, response);
        }
    }

    private void handleRegistration(User newUser, UserService userService, HttpSession session, HttpServletResponse response) throws IOException {
        userService.createUser(newUser);
        session.setAttribute("user", newUser);
        response.sendRedirect("/");
    }
}
