package iotbay.test;

import iotbay.controller.ProductDetailsController;
import iotbay.dao.DBConnector;
import iotbay.helper.ProjectConstants;
import iotbay.model.Product;
import iotbay.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Connection;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ProductDetailsControllerTest {
    private HttpServletRequest request;
    private HttpServletResponse response;
    private HttpSession session;
    private Connection connection;
    private ProductDetailsController productDetailsController;

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
        productDetailsController = new ProductDetailsController();
    }

    @Test
    @DisplayName("ProductDetailsController - Test valid product update")
    public void testUpdateProduct() {
        ProductService productService = new ProductService(connection);
        int productId = 1;
        Product product = productService.getProduct(productId);

        // Mock currentlySelectedProduct
        when(session.getAttribute(ProjectConstants.SESSION_ATTRIBUTE_CURRENTLY_SELECTED_PRODUCT)).thenReturn(product);

        product.setDescription("Updated description");

        // Mock request attributes
        when(request.getParameter(ProjectConstants.REQUEST_ATTRIBUTE_PRODUCT_ID)).thenReturn(String.valueOf(productId));
        when(request.getParameter(ProjectConstants.REQUEST_ATTRIBUTE_DESCRIPTION)).thenReturn(product.getDescription());
        when(request.getParameter(ProjectConstants.REQUEST_ATTRIBUTE_PRICE)).thenReturn(Double.toString(product.getPrice()));
        when(request.getParameter(ProjectConstants.REQUEST_ATTRIBUTE_STOCK)).thenReturn(Integer.toString(product.getQuantity()));
        when(request.getParameter(ProjectConstants.REQUEST_ATTRIBUTE_CATEGORY)).thenReturn(product.getCategory().toString());

        productDetailsController.doPost(request, response);

        assertEquals(product.toString(), productService.getProduct(productId).toString());
    }
}
