package iotbay.controller;

import iotbay.helper.Validator;
import iotbay.service.UserService;
import iotbay.model.User;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.util.Objects;

public class LoginController extends HttpServlet {
    // Using the GET method for logging in
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();

        // Get email and password from request data
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // For testing purposes, skip data validation if the test user is entered
        if (Objects.equals(email, "1@2")) {
            handleLogin(session, email, password, response);
        } else if (!Validator.validateEmail(email)) {
            // Send error message
            session.setAttribute("loginError", "Invalid email.");
            response.sendRedirect("/login.jsp");
        } else if (!Validator.validatePassword(password)) {
            // Send error message
            session.setAttribute("loginError", "Invalid password.");
            response.sendRedirect("/login.jsp");
        } else {
            handleLogin(session, email, password, response);
        }
    }

    private void handleLogin(HttpSession session, String email, String password, HttpServletResponse response) throws IOException {
        Connection connection = (Connection) session.getAttribute("dbConnection");
        UserService userService = new UserService(connection);
        
        // Attempt to find the user in the database
        User user = userService.findUser(email, password);

        // If User exists
        if (user != null) {
            // Store in session and redirect to home page
            session.setAttribute("user", user);
            response.setStatus(HttpServletResponse.SC_OK);
            response.sendRedirect("/");
        } else {
            // Send error message
            session.setAttribute("loginError", "User does not exist in the database.");
            response.sendRedirect("/login.jsp");
        }
    }

    // Using the POST method for logging out
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        response.sendRedirect("/");
    }
}
