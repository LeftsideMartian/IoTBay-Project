package iotbay.test;

import iotbay.dao.DBConnector;
import iotbay.model.Category;
import iotbay.model.Product;
import iotbay.service.ProductService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import java.sql.Connection;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import static org.mockito.Mockito.*;

// Test class for ProductService
public class ProductServiceTest {
    DBConnector dbConnector;
    Connection connection;
    ProductService productService;

    @BeforeEach
    public void getConnection() {
        dbConnector = new DBConnector();
        connection = dbConnector.connect();
        productService = new ProductService(connection);
    }

    @AfterEach
    public void closeConnection() {
        dbConnector.closeConnection();
    }

    @Test
    @DisplayName("ProductService - Get an existing product")
    public void testExistingProduct() {
        Product product = productService.getProduct(1);
        assertEquals(product.getProductId(), 1);
    }

    @Test
    @DisplayName("ProductService - Get non existent product")
    public void testNonExistentProduct() {
        Product product = productService.getProduct(-1);
        assertNull(product);
    }
}
