package iotbay.test;

import iotbay.dao.DBConnector;
import iotbay.helper.ProjectConstants;
import iotbay.model.Category;
import iotbay.service.ProductService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductServiceTest {
    @Test
    @DisplayName("")
    public void testGetProduct() {
        DBConnector dbConnector = new DBConnector();
        ProductService productService = new ProductService(dbConnector.connect());

        System.out.println(productService.getProduct(1));
    }
}
