package iotbay.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Controller class for the manageOrders.jsp page
public class ManageOrdersController extends HttpServlet {
    // Using the GET method for fetching all orders
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        // Fetch session object from request
        // Fetch connection object from session
        // Create an instance of the OrderService class
        // Fetch User from session
        // If user has admin permissions, call .getAllOrders() method on OrderService object
        // If not, call .getAllOrders(int userId) method on OrderService object
        // Store orderList in session
        // redirect to manageOrders.jsp page
    }
}
