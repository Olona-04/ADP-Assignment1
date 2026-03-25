package za.ac.cput.Repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Product;
import za.ac.cput.Factory.ProductFactory;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {

    private ProductRepository repository;
    private Product product;

    @BeforeEach
    void setUp() {
        repository = new ProductRepository();
        product = ProductFactory.createProduct(
                "P001",
                "Microwave",
                "Samsung Microwave",
                1500.00,
                false
        );
    }

    @Test
    void create() {
        Product created = repository.create(product);
        assertNotNull(created);
        System.out.println(created);
    }

    @Test
    void read() {
        repository.create(product);
        Product found = repository.read("P001");
        assertNotNull(found);
        System.out.println(found);
    }

    @Test
    void update() {
        repository.create(product);

        Product updatedProduct = new Product.Builder()
                .SetProductId("P001")
                .SetProductName("Updated Microwave")
                .SetDescription("Updated Description")
                .SetPrice(2000.00)
                .SetIsAuction(false)
                .build();

        Product updated = repository.update(updatedProduct);

        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    void delete() {
        repository.create(product);
        boolean deleted = repository.delete("P001");
        assertTrue(deleted);
        System.out.println("Product deleted");
    }

    @Test
    void getAll() {
        repository.create(product);
        Set<Product> products = repository.getAll();
        assertFalse(products.isEmpty());
        System.out.println(products);
    }
}