package iotbay.helper;

import iotbay.model.Product;
import iotbay.service.ProductService;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

// Servlet for initialising the list of products in session
public class ProductsListInitialiser extends HttpServlet {
    private List<Product> productList;

    // Initialise productList to an empty list
    @Override
    public void init() {
        productList = new ArrayList<>();
    }

    // Fetch list of products and store in session
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        // Get connection from session
        HttpSession session = request.getSession();
        Connection connection = (Connection) session.getAttribute(ProjectConstants.SESSION_ATTRIBUTE_DBCONNECTION);

        // Get list of all products from a ProductService
        ProductService productService = new ProductService(connection);
        productList = productService.getAllProducts();

        // Store the list in session
        session.setAttribute(ProjectConstants.SESSION_ATTRIBUTE_PRODUCT_LIST, productList);
    }
}
