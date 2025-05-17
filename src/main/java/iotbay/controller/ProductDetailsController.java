package iotbay.controller;

import iotbay.helper.ProjectConstants;
import iotbay.model.Category;
import iotbay.model.Product;
import iotbay.service.ProductService;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.util.Arrays;

public class ProductDetailsController extends HttpServlet {
    // Using the POST method for updating product details
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        // Fetch session, fetch connection object from session and create a ProductService instance
        HttpSession session = request.getSession();
        Connection connection = (Connection) session.getAttribute(ProjectConstants.SESSION_ATTRIBUTE_DBCONNECTION);
        ProductService productService = new ProductService(connection);

        // Get current product from session
        Product currentlySelectedProduct = (Product) session.getAttribute(ProjectConstants.SESSION_ATTRIBUTE_CURRENTLY_SELECTED_PRODUCT);

        // Update product details
        currentlySelectedProduct.setDescription(request.getParameter(ProjectConstants.REQUEST_ATTRIBUTE_DESCRIPTION));
        currentlySelectedProduct.setPrice(Double.parseDouble(request.getParameter(ProjectConstants.REQUEST_ATTRIBUTE_PRICE)));
        currentlySelectedProduct.setQuantity(Integer.parseInt(request.getParameter(ProjectConstants.REQUEST_ATTRIBUTE_STOCK)));
        currentlySelectedProduct.setCategory(Category.fromString(request.getParameter(ProjectConstants.REQUEST_ATTRIBUTE_CATEGORY)));

        // Update product in the database
        productService.updateProduct(currentlySelectedProduct);

        // Send success message and try to redirect to manage products page
        session.setAttribute(ProjectConstants.SESSION_ATTRIBUTE_SUCCESS_MESSAGE, "Updated product details successfully!");

        try {
            response.sendRedirect(ProjectConstants.MANAGE_PRODUCTS_PAGE);
        } catch (IOException e) {
            System.out.println("Could not send redirect from Controller");
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }
}
