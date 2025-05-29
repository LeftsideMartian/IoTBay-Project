package iotbay.test;

import iotbay.controller.SearchProductsController;
import iotbay.dao.DBConnector;
import iotbay.helper.ProjectConstants;
import iotbay.model.Product;

import org.junit.jupiter.api.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class SearchProductsControllerTest {

    private HttpServletRequest request;
    private HttpServletResponse response;
    private HttpSession session;
    private RequestDispatcher dispatcher;
    private DBConnector dbConnector;
    private Connection connection;
    private SearchProductsController controller;

    private Map<String, Object> sessionAttributes;

    @BeforeEach
    public void setUp() {
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        session = mock(HttpSession.class);
        dispatcher = mock(RequestDispatcher.class);

        dbConnector = new DBConnector();
        connection = dbConnector.connect();

        sessionAttributes = new HashMap<>();

        // Simulate session behavior
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute(anyString())).thenAnswer(invocation -> sessionAttributes.get(invocation.getArgument(0)));
        doAnswer(invocation -> {
            String key = invocation.getArgument(0);
            Object value = invocation.getArgument(1);
            sessionAttributes.put(key, value);
            return null;
        }).when(session).setAttribute(anyString(), any());

        when(session.getAttribute(ProjectConstants.SESSION_ATTRIBUTE_DBCONNECTION)).thenReturn(connection);
        when(request.getRequestDispatcher("search.jsp")).thenReturn(dispatcher);

        controller = new SearchProductsController();
    }

    @AfterEach
    public void tearDown() {
        dbConnector.closeConnection();
    }

    @Test
    @DisplayName("SearchProductsController - Filters products by keyword 'smart'")
    public void testSearchWithKeywordSmart() throws Exception {
        when(request.getParameter("searchTerm")).thenReturn("smart");

        controller.doGet(request, response);

        @SuppressWarnings("unchecked")
        List<Product> filteredProducts = (List<Product>) sessionAttributes.get(ProjectConstants.SESSION_ATTRIBUTE_PRODUCT_LIST);

        assertNotNull(filteredProducts, "Filtered product list should not be null");
        assertFalse(filteredProducts.isEmpty(), "Filtered product list should not be empty");

        for (Product product : filteredProducts) {
            assertTrue(product.getProductName().toLowerCase().contains("smart"),
                "Product name does not contain 'smart': " + product.getProductName());
        }

        verify(dispatcher).forward(request, response);
    }
}
