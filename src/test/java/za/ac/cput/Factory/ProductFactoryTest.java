package za.ac.cput.Factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Product;

import static org.junit.jupiter.api.Assertions.*;

class ProductFactoryTest {

    @Test
    void createProduct() {

        Product product = ProductFactory.createProduct(
                "P001",
                "Microwave",
                "Samsung 25L Microwave",
                1500.00,
                false
        );

        assertNotNull(product);
        assertEquals("P001", product.getProductId());
        assertEquals("Microwave", product.getProductName());
        assertEquals("Samsung 25L Microwave", product.getDescription());
        assertEquals(1500.00, product.getPrice());
        assertFalse(product.isAuction());

        System.out.println(product);
    }
}