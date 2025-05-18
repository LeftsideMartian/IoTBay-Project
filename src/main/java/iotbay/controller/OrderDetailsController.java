package iotbay.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Controller class for the orderDetails.jsp page
public class OrderDetailsController extends HttpServlet {
    // Using the POST method for updating order details
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        // Fetch session object from request
        // Fetch connection object from session
        // Create an instance of the OrderService class
        // Fetch orderId from request data
        // call .getOrder(int orderId) method on OrderService object
        // Store order in session
        // redirect to orderDetails.jsp page (More or less copy the productDetails.jsp page)
    }
}
