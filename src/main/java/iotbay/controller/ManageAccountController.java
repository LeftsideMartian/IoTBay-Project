package iotbay.controller;

import iotbay.model.User;
import iotbay.service.UserService;
import iotbay.helper.ProjectConstants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;

@WebServlet("/manageAccount")
public class ManageAccountController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        // Get connection and user from session
        Connection connection = (Connection) session.getAttribute(ProjectConstants.SESSION_ATTRIBUTE_DBCONNECTION);
        User user = (User) session.getAttribute(ProjectConstants.SESSION_ATTRIBUTE_USER);

        if (connection == null || user == null) {
            response.sendRedirect("login.jsp"); // if not logged in
            return;
        }

        // Retrieve updated values from form
        String newFirstName = request.getParameter("firstName");
        String newLastName = request.getParameter("lastName");
        String newEmail = request.getParameter("email");

        // Update user object in session
        user.setFirstName(newFirstName);
        user.setLastName(newLastName);
        user.setEmail(newEmail);

        // Call your existing method (e.g., updateUser)
        UserService userService = new UserService(connection);
        userService.updateUser(user); // <- reuse existing method here

            session.setAttribute(ProjectConstants.SESSION_ATTRIBUTE_USER, user);
            response.sendRedirect("manageAccount.jsp");
        
    }
}
