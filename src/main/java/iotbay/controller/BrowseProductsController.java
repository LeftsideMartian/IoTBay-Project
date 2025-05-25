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

@WebServlet("/BrowseProducts")
public class BrowseProductsController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
        session.setAttribute("productList", productList);

        // Forward to browseProducts.jsp for rendering the product list
        request.getRequestDispatcher("browseProducts.jsp").forward(request, response);
    }
}


