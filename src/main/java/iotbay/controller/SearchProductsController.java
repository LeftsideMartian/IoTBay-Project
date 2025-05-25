package iotbay.controller;

import iotbay.helper.ProjectConstants;
import iotbay.model.Product;
import iotbay.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/SearchProducts")
public class SearchProductsController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get current session
        HttpSession session = request.getSession();

        // Retrieve DB connection object from session using constant key
        Connection connection = (Connection) session.getAttribute(ProjectConstants.SESSION_ATTRIBUTE_DBCONNECTION);

        if (connection == null) {
            // If connection missing, redirect (could be login or error page)
            response.sendRedirect(ProjectConstants.LOGIN_PAGE);
            return;
        }

        // Instantiate ProductService with the connection
        ProductService productService = new ProductService(connection);

        // Get search term parameter (default to empty string)
        String searchTerm = request.getParameter("searchTerm") == null ? "" : request.getParameter("searchTerm").trim().toLowerCase();

        // Fetch all products
        List<Product> allProducts = productService.getAllProducts();

        // Filter products by name matching search term
        List<Product> filteredProducts = allProducts.stream()
                .filter(p -> p.getProductName().toLowerCase().contains(searchTerm))
                .collect(Collectors.toList());

        // Store filtered list in session
        session.setAttribute(ProjectConstants.SESSION_ATTRIBUTE_PRODUCT_LIST, filteredProducts);

        // Forward to search.jsp for rendering
        response.sendRedirect(ProjectConstants.SEARCH_PAGE);
    }
}