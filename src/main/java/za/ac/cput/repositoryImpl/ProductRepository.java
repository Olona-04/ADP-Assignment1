package za.ac.cput.Repository;

import za.ac.cput.Domain.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {

    private static ProductRepository repository = null;
    private List<Product> productDB;

    private ProductRepository() {
        productDB = new ArrayList<>();
    }

    public static ProductRepository getRepository() {
        if (repository == null) {
            repository = new ProductRepository();
        }
        return repository;
    }

    @Override
    public Product create(Product product) {
        productDB.add(product);
        return product;
    }

    @Override
    public Product read(String productId) {
        for (Product product : productDB) {
            if (product.getProductId().equals(productId)) {
                return product;
            }
        }
        return null;
    }

    @Override
    public Product update(Product product) {
        Product existingProduct = read(product.getProductId());

        if (existingProduct != null) {
            productDB.remove(existingProduct);
            productDB.add(product);
            return product;
        }

        return null;
    }

    @Override
    public boolean delete(String productId) {
        Product product = read(productId);

        if (product != null) {
            productDB.remove(product);
            return true;
        }

        return false;
    }

    @Override
    public List<Product> getAll() {
        return productDB;
    }
}
