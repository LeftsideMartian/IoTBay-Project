package iotbay.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Controller class for the placeOrder.jsp page
public class PlaceOrderController extends HttpServlet {
    // Using the GET method for browsing products
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        // Fetch session object from request
        // Fetch connection object from session
        // Create an instance of the OrderService class
        // Construct an Order model object using request data
        // Call .createOrder(Order order) method on OrderService object
        // redirect to browseProducts.jsp page
    }
}
