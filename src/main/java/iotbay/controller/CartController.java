package iotbay.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.io.IOException;
import iotbay.helper.ProjectConstants;
import iotbay.model.Product;

// Controller class to manage products in the cart
public class CartController extends HttpServlet {
    // Using POST method for cart updates from the header menu
    @Override
    @SuppressWarnings("unchecked")
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
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

            // Remove products from cart
            if (productIds != null) {
                for (Product product : cart) {
                    for (String productId : productIds) {
                        int parsedProductId = Integer.parseInt(productId);
                        if (product.getProductId() == parsedProductId) {
                            newCart.add(product);
                        }
                    }
                }
            }

            // Update quantities in cart
            for (Product product : newCart) {
                String quantityString = request.getParameter(String.valueOf(product.getProductId()) + ":quantity");
                if (quantityString != null) {
                    int quantity = Integer.valueOf(quantityString);
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