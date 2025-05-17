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
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        Connection connection = (Connection) session.getAttribute(ProjectConstants.SESSION_ATTRIBUTE_DBCONNECTION);
        ProductService productService = new ProductService(connection);

        Product currentlySelectedProduct = (Product) session.getAttribute(ProjectConstants.SESSION_ATTRIBUTE_CURRENTLY_SELECTED_PRODUCT);

        currentlySelectedProduct.setDescription(request.getParameter(ProjectConstants.REQUEST_ATTRIBUTE_DESCRIPTION));
        currentlySelectedProduct.setPrice(Double.parseDouble(request.getParameter(ProjectConstants.REQUEST_ATTRIBUTE_PRICE)));
        currentlySelectedProduct.setQuantity(Integer.parseInt(request.getParameter(ProjectConstants.REQUEST_ATTRIBUTE_STOCK)));
        currentlySelectedProduct.setCategory(Category.fromString(request.getParameter(ProjectConstants.REQUEST_ATTRIBUTE_CATEGORY)));

        productService.updateProduct(currentlySelectedProduct);

        session.setAttribute(ProjectConstants.SESSION_ATTRIBUTE_SUCCESS_MESSAGE, "Updated product details successfully!");

        try {
            response.sendRedirect(ProjectConstants.MANAGE_PRODUCTS_PAGE);
        } catch (IOException e) {
            System.out.println("Could not send redirect from Controller");
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }
}
