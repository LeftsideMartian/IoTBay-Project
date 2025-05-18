package iotbay.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Controller class for the searchProducts.jsp page
public class SearchProductsController extends HttpServlet {
    // Using the GET method for searching products
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        // Fetch session object from request
        // Fetch connection object from session
        // Create an instance of the ProductService class
        // get search term from request object
        // call .getAllProducts() method on ProductService object
        // Filter the product list for products whose name contains the search term
        // Store productList in session
        // redirect to searchProducts.jsp page
    }
}