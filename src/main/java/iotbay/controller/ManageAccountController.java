package iotbay.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Controller class for the manageAccount.jsp page
public class ManageAccountController extends HttpServlet {
    // Using the POST method for updating account details
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        // Fetch session object from request
        // Fetch connection object from session
        // Create an instance of the UserService class
        // Fetch user from session
        // Fetch user details from the request object (use registercontroller as reference)
        // Update user object with new details
        // call .updateUser() method from UserService
        // redirect to manageAccount.jsp page
    }
    
}
