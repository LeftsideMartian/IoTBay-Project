package iotbay.helper;

import iotbay.model.Product;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

// Servlet for initialising the cart in session
public class CartInitialiser extends HttpServlet {
    // Fetch list of products and store in session
    @Override
    @SuppressWarnings("unchecked")
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        // Get connection from session
        HttpSession session = request.getSession();

        // Fetch cart from session
        List<Product> cart = (List<Product>) session.getAttribute(ProjectConstants.SESSION_ATTRIBUTE_CART);

        // If it does not exist, create it
        if (cart == null) {
            session.setAttribute(ProjectConstants.SESSION_ATTRIBUTE_CART, new ArrayList<Product>());
        }
    }
}
