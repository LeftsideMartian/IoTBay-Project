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

public class ManageProductsController extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        Connection connection = (Connection) session.getAttribute(ProjectConstants.SESSION_ATTRIBUTE_DBCONNECTION);
        ProductService productService = new ProductService(connection);

        int productId = Integer.parseInt(request.getParameterNames().nextElement());
        Product product = productService.getProduct(productId);

        session.setAttribute(ProjectConstants.SESSION_ATTRIBUTE_CURRENTLY_SELECTED_PRODUCT, product);
        try {
            response.sendRedirect(ProjectConstants.PRODUCT_DETAILS_PAGE);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
