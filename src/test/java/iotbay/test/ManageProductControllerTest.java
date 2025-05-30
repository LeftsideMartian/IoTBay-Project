package iotbay.test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import iotbay.model.Product;
import iotbay.model.User;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import iotbay.controller.ManageProductsController;
import iotbay.dao.DBConnector;
import iotbay.helper.ProjectConstants;
import iotbay.service.ProductService;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import java.sql.Connection;

public class ManageProductControllerTest {
    private HttpServletRequest request;
    private HttpServletResponse response;
    private HttpSession session;
    DBConnector dbConnector;
    private Connection connection;
    private ManageProductsController manageProductsController;

    @BeforeEach
    public void beforeAllTests() {
        // Mock request, response and session objects, and request.getSession() method
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        session = mock(HttpSession.class);
        when(request.getSession()).thenReturn(session);

        // Put connection object into session
        dbConnector = new DBConnector();
        connection = dbConnector.connect();
        User user = new User();
        when(session.getAttribute(ProjectConstants.SESSION_ATTRIBUTE_DBCONNECTION)).thenReturn(connection);
        when(session.getAttribute(ProjectConstants.SESSION_ATTRIBUTE_USER)).thenReturn(user);

        // Create controller
        manageProductsController = new ManageProductsController();
    }

    @AfterEach
    public void closeConnection() {
        dbConnector.closeConnection();
    }

    @Test
    @DisplayName("ManageProductController - Test valid product selection")
    public void testValidProduct() {
        ProductService productService = new ProductService(connection);
        int productId = 1;
        Product product = productService.getProduct(productId);

        // Mock productId attribute
        when(request.getParameter(ProjectConstants.REQUEST_ATTRIBUTE_PRODUCT_ID)).thenReturn(String.valueOf(productId));

        manageProductsController.doPost(request, response);

        verify(session).setAttribute(ProjectConstants.SESSION_ATTRIBUTE_CURRENTLY_SELECTED_PRODUCT, product);
    }

    @Test
    @DisplayName("ManageProductController - Test invalid product selection")
    public void testInvalidProduct() {
        int productId = -1;
        Product product = null;

        // Mock productId attribute
        when(request.getParameter(ProjectConstants.REQUEST_ATTRIBUTE_PRODUCT_ID)).thenReturn(String.valueOf(productId));

        manageProductsController.doPost(request, response);

        verify(session).setAttribute(ProjectConstants.SESSION_ATTRIBUTE_ERROR, "Product not found.");
    }
}
