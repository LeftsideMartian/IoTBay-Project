package iotbay.controller;

import iotbay.helper.ProjectConstants;
import iotbay.model.Product;
import iotbay.service.ProductService;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet("/BrowseProducts")
public class BrowseProductsController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();

        // Retrieve DB connection object from session using constant key
        Connection connection = (Connection) session.getAttribute(ProjectConstants.SESSION_ATTRIBUTE_DBCONNECTION);

        if (connection == null) {
            // Redirect to login or error page if no DB connection
            response.sendRedirect("login.jsp");
            return;
        }

        // Instantiate ProductService with the connection
        ProductService productService = new ProductService(connection);

        // Fetch all products
        List<Product> productList = productService.getAllProducts();

        // Store product list in session
        session.setAttribute(ProjectConstants.SESSION_ATTRIBUTE_PRODUCT_LIST, productList);

        // Forward to browseProducts.jsp for rendering the product list
        response.sendRedirect(ProjectConstants.BROWSE_PAGE);
        return;
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();

        Connection connection = (Connection) session.getAttribute(ProjectConstants.SESSION_ATTRIBUTE_DBCONNECTION);
        ProductService productService = new ProductService(connection);

        // Fetch the current cart, and the id of the product to add to it
        List<Product> cart = (List<Product>) session.getAttribute(ProjectConstants.SESSION_ATTRIBUTE_CART);
        int productId = Integer.valueOf(request.getParameter(ProjectConstants.REQUEST_ATTRIBUTE_PRODUCT_ID));

        try {
            // Check if the product is already in cart
            for (Product product : cart) {
                if (product.getProductId() == productId) {
                    session.setAttribute(ProjectConstants.SESSION_ATTRIBUTE_ERROR, "Product already in cart.");
                    response.sendRedirect(ProjectConstants.BROWSE_PAGE);
                    return;
                }
            }

            // Fetch product object from DB
            Product product = productService.getProduct(productId);
            // If its in stock
            if (product.getQuantity() > 0) {
                product.setQuantity(1);
                cart.add(product);

                session.setAttribute(ProjectConstants.SESSION_ATTRIBUTE_SUCCESS_MESSAGE, "Product added to cart.");
                response.sendRedirect(ProjectConstants.BROWSE_PAGE);
                return;
            } else {
                session.setAttribute(ProjectConstants.SESSION_ATTRIBUTE_ERROR, "Product is out of stock.");
                response.sendRedirect(ProjectConstants.BROWSE_PAGE);
                return;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


