package iotbay.test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import iotbay.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import iotbay.controller.ManageProductsController;
import iotbay.dao.DBConnector;
import iotbay.helper.ProjectConstants;
import iotbay.service.ProductService;
import static org.mockito.Mockito.*;
import java.sql.Connection;

public class ManageProductControllerTest {
    private HttpServletRequest request;
    private HttpServletResponse response;
    private HttpSession session;
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
        DBConnector dbConnector = new DBConnector();
        connection = dbConnector.connect();
        when(session.getAttribute(ProjectConstants.SESSION_ATTRIBUTE_DBCONNECTION)).thenReturn(connection);

        // Create controller
        manageProductsController = new ManageProductsController();
    }

    @Test
    @DisplayName("ManageProductController - Test valid product selection")
    public void testValidProduct() {
        ProductService productService = new ProductService(connection);
        int productId = 1;
        Product product = productService.getProduct(productId);

        // Mock productId attribute
        when(request.getParameter(ProjectConstants.REQUEST_ATTRIBUTE_PRODUCT_ID)).thenReturn(String.valueOf(productId));

        manageProductsController.doGet(request, response);

        verify(session).setAttribute(ProjectConstants.SESSION_ATTRIBUTE_CURRENTLY_SELECTED_PRODUCT, product);
    }

    @Test
    @DisplayName("ManageProductController - Test invalid product selection")
    public void testInvalidProduct() {
        int productId = -1;
        Product product = null;

        // Mock productId attribute
        when(request.getParameter(ProjectConstants.REQUEST_ATTRIBUTE_PRODUCT_ID)).thenReturn(String.valueOf(productId));

        manageProductsController.doGet(request, response);

        verify(session).setAttribute(ProjectConstants.SESSION_ATTRIBUTE_ERROR, "Product not found.");
    }
}
