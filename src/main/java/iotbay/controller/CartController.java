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

public class CartController extends HttpServlet {
    @Override
    @SuppressWarnings("unchecked")
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            HttpSession session = request.getSession();
            List<Product> cart = (List<Product>) session.getAttribute(ProjectConstants.SESSION_ATTRIBUTE_CART);

            List<Product> newCart = new ArrayList<>();

            List<String> productIds = Arrays.stream(request.getParameterValues(ProjectConstants.REQUEST_ATTRIBUTE_PRODUCT_ID)).collect(Collectors.toCollection(ArrayList::new));;

            for (Product product : cart) {
                for (String productId : productIds) {
                    int parsedProductId = Integer.parseInt(productId);
                    if (product.getProductId() == parsedProductId) {
                        newCart.add(product);
                        productIds.remove(productId);
                        break;
                    }
                }
            }

            session.setAttribute(ProjectConstants.SESSION_ATTRIBUTE_CART, newCart);
            response.sendRedirect(request.getParameter(ProjectConstants.REQUEST_ATTRIBUTE_PAGE));
        } catch (IOException e) {
            System.out.println("Could not send redirect from CartController");
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }
}
