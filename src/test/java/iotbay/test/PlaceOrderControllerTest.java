package iotbay.test;

import iotbay.controller.PlaceOrderController;
import iotbay.helper.ProjectConstants;
import iotbay.model.Product;
import iotbay.model.User;
import org.junit.jupiter.api.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.*;

public class PlaceOrderControllerTest {
    private HttpServletRequest request;
    private HttpServletResponse response;
    private HttpSession session;
    private Connection connection;
    private PlaceOrderController placeOrderController;

    @BeforeEach
    public void setUp() {
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        session = mock(HttpSession.class);
        connection = mock(Connection.class);
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute(ProjectConstants.SESSION_ATTRIBUTE_DBCONNECTION)).thenReturn(connection);

        placeOrderController = new PlaceOrderController();
    }

    @Test
    public void testProceedToCheckoutAndReviewOrderSummary() {
        // Example using a Product with a constructor: (int id, String name, double price, int quantity, String description)
        List<Product> cart = new ArrayList<>();
        Product prod = new Product(1, "TestProduct", 2, 99.99, "testing");
        cart.add(prod);
        when(session.getAttribute(ProjectConstants.SESSION_ATTRIBUTE_CART)).thenReturn(cart);
        when(session.getAttribute(ProjectConstants.SESSION_ATTRIBUTE_USER)).thenReturn(null);

        List<Product> cartRetrieved = (List<Product>) session.getAttribute(ProjectConstants.SESSION_ATTRIBUTE_CART);
        Assertions.assertNotNull(cartRetrieved);
        Assertions.assertEquals(1, cartRetrieved.size());
        Assertions.assertEquals("TestProduct", cartRetrieved.get(0).getProductName());
    }

    @Test
    public void testEnterShippingAndPaymentDetailsAndPlaceOrder() throws Exception {
        List<Product> cart = new ArrayList<>();
        Product prod = new Product(1, "TestProduct", 99.99, 2, "testing");
        cart.add(prod);

        User user = new User(0, null, null, null, null, null);
        user.setUserId(3);
        user.setFirstName("Bob");
        user.setLastName("Smith");
        user.setEmail("bob@email.com");
        user.setPassword("pw");

        when(session.getAttribute(ProjectConstants.SESSION_ATTRIBUTE_CART)).thenReturn(cart);
        when(session.getAttribute(ProjectConstants.SESSION_ATTRIBUTE_USER)).thenReturn(user);

        when(request.getParameter("firstName")).thenReturn("Bob");
        when(request.getParameter("lastName")).thenReturn("Smith");
        when(request.getParameter("address")).thenReturn("123 Main St");
        when(request.getParameter("cardNumber")).thenReturn("4111111111111111");

        placeOrderController.doPost(request, response);

        verify(session).setAttribute(eq(ProjectConstants.SESSION_ATTRIBUTE_CART), any(ArrayList.class));
        verify(response).sendRedirect("index.jsp");
    }

    @Test
    public void testMissingShippingOrPaymentDetails() throws Exception {
        List<Product> cart = new ArrayList<>();
        Product prod = new Product(1, "TestProduct", 99.99, 2, "testing");
        cart.add(prod);

        User user = new User(0, null, null, null, null, null);
        user.setUserId(3);
        user.setFirstName("Bob");
        user.setLastName("Smith");
        user.setEmail("bob@email.com");
        user.setPassword("pw");

        when(session.getAttribute(ProjectConstants.SESSION_ATTRIBUTE_CART)).thenReturn(cart);
        when(session.getAttribute(ProjectConstants.SESSION_ATTRIBUTE_USER)).thenReturn(user);

        when(request.getParameter("firstName")).thenReturn(""); // missing
        when(request.getParameter("lastName")).thenReturn("Smith");
        when(request.getParameter("address")).thenReturn("123 Main St");
        when(request.getParameter("cardNumber")).thenReturn("4111111111111111");

        placeOrderController.doPost(request, response);

        verify(session).setAttribute(eq(ProjectConstants.SESSION_ATTRIBUTE_ERROR), eq("Please fill in all required fields."));
        verify(response).sendRedirect("checkout.jsp?error=incomplete");
    }

    @Test
    public void testPlaceOrderWithEmptyCartOrNoUser() throws Exception {
        when(session.getAttribute(ProjectConstants.SESSION_ATTRIBUTE_CART)).thenReturn(new ArrayList<>());
        when(session.getAttribute(ProjectConstants.SESSION_ATTRIBUTE_USER)).thenReturn(null);

        placeOrderController.doPost(request, response);

        verify(session).setAttribute(eq(ProjectConstants.SESSION_ATTRIBUTE_ERROR), eq("Cart is empty or user not logged in."));
        verify(response).sendRedirect("checkout.jsp?error=empty");
    }
}