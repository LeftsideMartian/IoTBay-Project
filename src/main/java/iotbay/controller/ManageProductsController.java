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

// Controller class for the manageProducts.jsp page
public class ManageProductsController extends HttpServlet {
    // Using the GET method for managing products
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        // Fetch session, fetch connection object from session and create a ProductService instance
        HttpSession session = request.getSession();
        Connection connection = (Connection) session.getAttribute(ProjectConstants.SESSION_ATTRIBUTE_DBCONNECTION);
        ProductService productService = new ProductService(connection);

        // Get productId from request data
        int productId = Integer.parseInt(request.getParameter(ProjectConstants.REQUEST_ATTRIBUTE_PRODUCT_ID));
        // Attempt to find the product in the database
        Product product = productService.getProduct(productId);

        if (product != null) {
            // And store in session
            session.setAttribute(ProjectConstants.SESSION_ATTRIBUTE_CURRENTLY_SELECTED_PRODUCT, product);
            // Try to redirect to the product details page
            try {
                response.sendRedirect(ProjectConstants.PRODUCT_DETAILS_PAGE);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            // Send error message for invalid product, and try to redirect to the manage products page
            try {
                session.setAttribute(ProjectConstants.SESSION_ATTRIBUTE_ERROR, "Product not found.");
                response.sendRedirect(ProjectConstants.MANAGE_PRODUCTS_PAGE);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
