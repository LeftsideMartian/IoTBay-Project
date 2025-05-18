package iotbay.service;

import iotbay.helper.ProjectConstants;
import iotbay.model.DeliveryStatus;
import iotbay.model.Order;
import iotbay.model.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/* 
Service class for performing CRUD operations on the Orders
(Note this table is not called Order, as it conflicts with an SQL keyword)
and OrderProduct tables
*/
public class OrderService extends DBService {
    // Constructor simply calls super()
    public OrderService(Connection connection) {
        super(connection);
    }

    // CRUD - Create method
    public void createOrder(Order order) {
        // Fetch query from SQL file
        String query = getQueryFromFile(ProjectConstants.ORDERS_QUERY_CREATE_ORDER);

        try {
            // Create row in order table
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, order.getOrderId());
            preparedStatement.setInt(2, order.getUserId());
            preparedStatement.setString(3, order.getEstimatedDeliveryDate().toString());
            // ESTIMATED DELIVERY DATE MAY BE FORMATTED WRONG
            preparedStatement.setString(4, order.getDeliveryStatus());
            preparedStatement.setString(5, order.getLogData());

            preparedStatement.executeUpdate();

            query = getQueryFromFile(ProjectConstants.ORDERPRODUCT_QUERY_CREATE_ORDER_PRODUCT);

            // For each product, create row in the OrderProduct table
            for (Product product : order.getProducts()) {
                preparedStatement = connection.prepareStatement(query);

                preparedStatement.setInt(1, order.getOrderId());
                preparedStatement.setInt(2, product.getProductId());
                preparedStatement.setInt(3, product.getQuantity());

                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // CRUD - Read (Single order)
    public Order getOrder(int orderId) {
        List<Order> orders = getAllOrders();

        for (Order order : orders) {
            if (order.getOrderId() == orderId) {
                return order;
            }
        }

        return null;
    }

    public List<Order> getAllOrders() {
        String query = getQueryFromFile(ProjectConstants.ORDERS_QUERY_GET_ALL_ORDERS);

        try {
            ResultSet results = connection.prepareStatement(query).executeQuery();
            List<Order> orders = new ArrayList<>();

            while (results.next()) {
                orders.add(new Order(
                    results.getInt(ProjectConstants.ORDERS_COLUMN_ORDER_ID),
                    results.getInt(ProjectConstants.USER_COLUMN_USER_ID),
                    results.getDate(ProjectConstants.ORDERS_COLUMN_ESTIMATED_DELIVERY_DATE),
                    DeliveryStatus.fromString(results.getString(ProjectConstants.ORDERS_COLUMN_DELIVERY_STATUS)),
                    results.getString(ProjectConstants.ORDERS_COLUMN_LOG_DATA),
                    getAllOrderProducts(results.getInt(ProjectConstants.ORDERS_COLUMN_ORDER_ID))
                ));
            }

            return orders;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private List<Product> getAllOrderProducts(int orderId) {
        // Get a product service
        // Create query using orderId
        // For each resulting row, append a list with a Product object
        // Return list of product
        ProductService productService = new ProductService(connection);
        String query = getQueryFromFile(ProjectConstants.ORDERPRODUCT_QUERY_GET_ALL_ORDER_PRODUCTS);
        List<Product> products = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, orderId);
            ResultSet results = preparedStatement.executeQuery();

            while (results.next()) {
                int productId = results.getInt(ProjectConstants.PRODUCT_COLUMN_PRODUCT_ID);
                Product product = productService.getProduct(productId);
                product.setQuantity(results.getInt(ProjectConstants.ORDERPRODUCT_COLUMN_QUANTITY));
                products.add(product);
            }

            return products;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
