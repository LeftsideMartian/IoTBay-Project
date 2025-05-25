package iotbay.controller;

import iotbay.model.User;
import iotbay.service.UserService;
import iotbay.helper.ProjectConstants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.util.Objects;

@WebServlet("/manageAccount")
public class ManageAccountController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        // Get connection and user from session
        Connection connection = (Connection) session.getAttribute(ProjectConstants.SESSION_ATTRIBUTE_DBCONNECTION);
        User user = (User) session.getAttribute(ProjectConstants.SESSION_ATTRIBUTE_USER);

        if (connection == null || user == null) {
            response.sendRedirect(ProjectConstants.HOME_PAGE); // if not logged in
            return;
        }

        String typeOfUpdate = request.getParameter("typeOfUpdate");

        if (Objects.equals(typeOfUpdate, "updateDetails")) {
            // Retrieve updated values from form
            String newFirstName = request.getParameter(ProjectConstants.REQUEST_ATTRIBUTE_USER_FIRST_NAME);
            String newLastName = request.getParameter(ProjectConstants.REQUEST_ATTRIBUTE_USER_LAST_NAME);
            String newEmail = request.getParameter(ProjectConstants.REQUEST_ATTRIBUTE_USER_EMAIL);
    
            // Update user object in session
            user.setFirstName(newFirstName);
            user.setLastName(newLastName);
            user.setEmail(newEmail);
        } else if (Objects.equals(typeOfUpdate, "updatePassword")) {
            String currentPassword = request.getParameter("currentPassword");
            if (Objects.equals(currentPassword, user.getPassword())) {
                String newPassword = request.getParameter("newPassword");
                user.setPassword(newPassword);
            } else {
                session.setAttribute(ProjectConstants.SESSION_ATTRIBUTE_ERROR, "Current password is incorrect.");
                response.sendRedirect(ProjectConstants.MANAGE_ACCOUNT_PAGE);
            }
        }

        UserService userService = new UserService(connection);
        userService.updateUser(user);

        session.setAttribute(ProjectConstants.SESSION_ATTRIBUTE_USER, user);
        response.sendRedirect(ProjectConstants.MANAGE_ACCOUNT_PAGE);
    }
}
