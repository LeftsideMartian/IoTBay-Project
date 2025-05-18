package iotbay.controller;

import iotbay.helper.ProjectConstants;
import iotbay.model.Product;
import iotbay.service.ProductService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;

// Controller class for the browseProducts.jsp page
public class BrowseProductsController extends HttpServlet {
    // Using the GET method for browsing products
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        // Fetch session object from request
        // Fetch connection object from session
        // Create an instance of the ProductService class
        // call .getAllProducts() method on ProductService object
        // Store productList in session
        // redirect to browseProducts.jsp page
    }
}
