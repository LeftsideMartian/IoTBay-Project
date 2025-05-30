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
            String currentPage = request.getParameter(ProjectConstants.REQUEST_ATTRIBUTE_PAGE);

            List<Product> cart = (List<Product>) session.getAttribute(ProjectConstants.SESSION_ATTRIBUTE_CART);
            List<Product> newCart = new ArrayList<>();

            String[] params = request.getParameterValues(ProjectConstants.REQUEST_ATTRIBUTE_PRODUCT_ID);

            if (params == null) {
                session.setAttribute(ProjectConstants.SESSION_ATTRIBUTE_CART, newCart);
                response.sendRedirect(currentPage);
                return;
            }

            List<String> productIds = Arrays.stream(params).collect(Collectors.toCollection(ArrayList::new));

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
                }
            }

            session.setAttribute(ProjectConstants.SESSION_ATTRIBUTE_CART, newCart);
            session.setAttribute(ProjectConstants.SESSION_ATTRIBUTE_SUCCESS_MESSAGE, "Cart updated successfully.");
            response.sendRedirect(currentPage);
            return;
        } catch (IOException e) {
            System.out.println("Could not send redirect from CartController");
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }
}
