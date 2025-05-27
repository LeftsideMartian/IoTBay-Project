package iotbay.service;

import iotbay.helper.ProjectConstants;
import iotbay.model.Category;
import iotbay.model.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

// Service class for performing CRUD operations on the Product table
public class ProductService extends DBService {
    // Constructor simply calls super()
    public ProductService (Connection connection) {
        super(connection);
    }

    // CRUD - Create
    public void createProduct(Product product) {
        String query = getQueryFromFile(ProjectConstants.PRODUCT_QUERY_CREATE);

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, product.getProductName());
            preparedStatement.setString(2, product.getDescription());
            preparedStatement.setDouble(3, product.getPrice());
            preparedStatement.setInt(4, product.getQuantity());
            preparedStatement.setString(5, product.getCategory().toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // CRUD - Read (Single product)
    public Product getProduct(int productId) {
        String query = getQueryFromFile(ProjectConstants.PRODUCT_QUERY_GET);

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, productId);

            ResultSet results = preparedStatement.executeQuery();

            if (results.next()) {
                return getProductFromResultSet(results);
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // CRUD - Read (All products)
    public List<Product> getAllProducts() {
        try {
            ResultSet results = connection.prepareStatement(getQueryFromFile(ProjectConstants.PRODUCT_QUERY_GET_ALL)).executeQuery();

            List<Product> allProducts = new ArrayList<>();

            while (results.next()) {
                allProducts.add(getProductFromResultSet(results));
            }

            return allProducts;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Product> getAllInStockProducts() {
        List<Product> allProducts = getAllProducts();

        return allProducts.stream().filter(p -> p.getQuantity() > 0).collect(Collectors.toList());
    }

    // CRUD - Update
    public void updateProduct(Product product) {
        String query = getQueryFromFile(ProjectConstants.PRODUCT_QUERY_UPDATE);

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, product.getProductName());
            preparedStatement.setString(2, product.getDescription());
            preparedStatement.setDouble(3, product.getPrice());
            preparedStatement.setInt(4, product.getQuantity());
            preparedStatement.setString(5, product.getCategory().toString());
            preparedStatement.setInt(6, product.getProductId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // CRUD - Delete Service class for performing CRUD operations on the User table
    public void deleteProduct(Product product) {
        if (product != null) {
            String query = getQueryFromFile(ProjectConstants.PRODUCT_QUERY_DELETE);

            try {
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, product.getProductId());

                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    // Helper function to convert a ResultSet row into a Product object
    private Product getProductFromResultSet(ResultSet resultSet) throws SQLException {
        return new Product(
            resultSet.getInt(ProjectConstants.PRODUCT_COLUMN_PRODUCT_ID),
            resultSet.getString(ProjectConstants.PRODUCT_COLUMN_PRODUCT_NAME),
            resultSet.getString(ProjectConstants.PRODUCT_COLUMN_DESCRIPTION),
            resultSet.getDouble(ProjectConstants.PRODUCT_COLUMN_PRICE),
            resultSet.getInt(ProjectConstants.PRODUCT_COLUMN_STOCK_QUANTITY),
            Category.fromString(resultSet.getString(ProjectConstants.PRODUCT_COLUMN_CATEGORY))
        );
    }
}
