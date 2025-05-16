package iotbay.test;

import iotbay.dao.DBConnector;
import iotbay.model.Category;
import iotbay.model.Product;
import iotbay.service.ProductService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ProductServiceTest {
    Product testProduct = new Product(1, "Temperature Sensor", "High-precision temperature sensor with digital output", 29.99, 100, Category.SENSOR);

    @Test
    @DisplayName("ProductService - Get an existing product")
    public void testExistingProduct() {
        DBConnector dbConnector = new DBConnector();
        ProductService productService = new ProductService(dbConnector.connect());

        Product product = productService.getProduct(testProduct.getProductId());
        assertEquals(product.toString(), testProduct.toString());

        productService.closeConnection();
    }
    @Test
    @DisplayName("ProductService - Get non existent product")
    public void testNonExistentProduct() {
        DBConnector dbConnector = new DBConnector();
        ProductService productService = new ProductService(dbConnector.connect());

        Product product = productService.getProduct(-1);
        assertNull(product);

        productService.closeConnection();
    }
}
