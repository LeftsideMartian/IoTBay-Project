package iotbay.controller;

import iotbay.model.DeliveryStatus;
import iotbay.model.Order;
import iotbay.model.Product;
import iotbay.model.User;
import iotbay.service.OrderService;
import iotbay.helper.ProjectConstants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/placeOrder")
public class PlaceOrderController extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(ProjectConstants.SESSION_ATTRIBUTE_USER);

        try {
            if (user == null) {
                response.sendRedirect(ProjectConstants.LOGIN_PAGE);
                return;
            } else {
                response.sendRedirect(ProjectConstants.PLACE_ORDER_PAGE);
                return;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get session and required attributes
        HttpSession session = request.getSession();
        Connection connection = (Connection) session.getAttribute(ProjectConstants.SESSION_ATTRIBUTE_DBCONNECTION);

        User user = (User) session.getAttribute(ProjectConstants.SESSION_ATTRIBUTE_USER);
        List<Product> cart = (List<Product>) session.getAttribute(ProjectConstants.SESSION_ATTRIBUTE_CART);

        // Validate user and cart
        if (user == null || cart == null || cart.isEmpty()) {
            session.setAttribute(ProjectConstants.SESSION_ATTRIBUTE_ERROR, "Cart is empty or user not logged in.");
            response.sendRedirect(ProjectConstants.PLACE_ORDER_PAGE);
            return;
        }

        // Get form parameters
        String address = request.getParameter("address");
        String cardNumber = request.getParameter("cardNumber");

        System.out.println(address);
        System.out.println(cardNumber);

        // Validate required fields
        if (address == null || cardNumber == null || address.isEmpty() || cardNumber.isEmpty()) {
            session.setAttribute(ProjectConstants.SESSION_ATTRIBUTE_ERROR, "Please fill in all required fields.");
            response.sendRedirect(ProjectConstants.PLACE_ORDER_PAGE);
            return;
        }

        // Create Order object
        Order order = new Order(-1, user.getUserId(), address, DeliveryStatus.IN_PROGRESS, cardNumber, cart);

        // Save order to database
        OrderService orderService = new OrderService(connection);
        System.out.println(order);
        orderService.createOrder(order);

        // Clear cart from session
        session.setAttribute(ProjectConstants.SESSION_ATTRIBUTE_CART, new ArrayList<Product>());
        session.setAttribute(ProjectConstants.SESSION_ATTRIBUTE_SUCCESS_MESSAGE, "Order placed successfully!");

        // Redirect to confirmation page
        response.sendRedirect(ProjectConstants.HOME_PAGE);
        return;
    }
}