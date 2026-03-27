package za.ac.cput.Repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Product;
import za.ac.cput.Factory.ProductFactory;
import za.ac.cput.repositoryImpl.ProductRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {

    private ProductRepository repository;
    private Product product;

    @BeforeEach
    void setUp() {
        repository = ProductRepository.getRepository();

        product = ProductFactory.createProduct(
                "P001",
                "Microwave",
                "Samsung Microwave",
                1500.00,
                false
        );

        repository.create(product);
    }

    @Test
    void getRepository() {
        ProductRepository repo = ProductRepository.getRepository();
        assertNotNull(repo);
        System.out.println("Repository instance created");
    }

    @Test
    void testCreate() {
        Product newProduct = ProductFactory.createProduct(
                "P002",
                "Air Fryer",
                "Philips Air Fryer",
                1800.00,
                false
        );

        Product created = repository.create(newProduct);

        assertNotNull(created);
        System.out.println(created);
    }

    @Test
    void testRead() {
        Product found = repository.read("P001");

        assertNotNull(found);
        System.out.println(found);
    }

    @Test
    void testUpdate() {

        Product updatedProduct = new Product.Builder()
                .SetProductId("P001")
                .SetProductName("Updated Microwave")
                .SetDescription("Updated Samsung Microwave")
                .SetPrice(2000.00)
                .SetIsAuction(false)
                .build();

        Product updated = repository.update(updatedProduct);

        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    void testDelete() {

        boolean deleted = repository.delete("P001");

        assertTrue(deleted);
        System.out.println("Product deleted successfully");
    }

    @Test
    void testGetAll() {

        List<Product> products = repository.getAll();

        assertFalse(products.isEmpty());
        System.out.println(products);
    }
}