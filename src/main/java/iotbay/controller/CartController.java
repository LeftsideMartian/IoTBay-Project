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
import java.io.PrintWriter; // Import PrintWriter
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/CartController")
public class CartController extends HttpServlet {
    @Override
    @SuppressWarnings("unchecked")
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json"); // Set content type to JSON
        PrintWriter out = response.getWriter(); // Get writer to send response

        try {
            HttpSession session = request.getSession();

            // Retrieve DB connection from session
            Connection connection = (Connection) session.getAttribute(ProjectConstants.SESSION_ATTRIBUTE_DBCONNECTION);
            if (connection == null) {
                // Send JSON error if no connection
                out.print("{\"status\":\"error\", \"message\":\"Database connection not found. Please login.\"}");
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED); // 401 Unauthorized
                return;
            }

            // Retrieve or initialize cart
            List<Product> cart = (List<Product>) session.getAttribute(ProjectConstants.SESSION_ATTRIBUTE_CART);
            if (cart == null) {
                cart = new ArrayList<>();
            }

            // Retrieve product info from request
            int productId = Integer.parseInt(request.getParameter("productId"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));

            // Fetch product from DB
            ProductService productService = new ProductService(connection);
            Product product = productService.getProduct(productId);

            if (product != null) {
                boolean foundInCart = false;
                for (Product p : cart) {
                    if (p.getProductId() == productId) {
                        p.setQuantity(p.getQuantity() + quantity);
                        foundInCart = true;
                        break;
                    }
                }
                if (!foundInCart) {
                    product.setQuantity(quantity);
                    cart.add(product);
                }
                // Update cart in session
                session.setAttribute(ProjectConstants.SESSION_ATTRIBUTE_CART, cart);
                // Send JSON success response
                out.print("{\"status\":\"success\", \"message\":\"Product added to cart!\"}");
            } else {
                // Send JSON error if product not found
                out.print("{\"status\":\"error\", \"message\":\"Product not found.\"}");
                response.setStatus(HttpServletResponse.SC_NOT_FOUND); // 404 Not Found
            }

        } catch (NumberFormatException e) {
            // Handle invalid product ID or quantity
            out.print("{\"status\":\"error\", \"message\":\"Invalid product ID or quantity provided.\"}");
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST); // 400 Bad Request
            e.printStackTrace();
        } catch (Exception e) {
            // Catch any other exceptions
            out.print("{\"status\":\"error\", \"message\":\"An unexpected error occurred: " + e.getMessage().replace("\"", "\\\"") + "\"}");
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR); // 500 Internal Server Error
            e.printStackTrace();
        } finally {
            out.flush(); // Ensure response is sent
        }
    }
}