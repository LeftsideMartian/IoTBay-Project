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

public class ProductService extends DBService {
    public ProductService (Connection connection) {
        super(connection);
    }

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

    public void updateProduct(Product product) {
        String query = getQueryFromFile(ProjectConstants.PRODUCT_QUERY_UPDATE);

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, product.getProductName());
            preparedStatement.setString(2, product.getDescription());
            preparedStatement.setDouble(3, product.getPrice());
            preparedStatement.setInt(4, product.getStockQuantity());
            preparedStatement.setString(5, product.getCategory());
            preparedStatement.setInt(6, product.getProductId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

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
