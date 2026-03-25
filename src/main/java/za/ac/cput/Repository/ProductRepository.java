package za.ac.cput.Repository;

import za.ac.cput.Domain.Product;
import java.util.HashSet;
import java.util.Set;

public class ProductRepository implements IProductRepository {

    private Set<Product> productDB = new HashSet<>();

    @Override
    public Product create(Product product) {
        productDB.add(product);
        return product;
    }

    @Override
    public Product read(String productId) {
        return productDB.stream()
                .filter(p -> p.getProductId().equals(productId))
                .findAny()
                .orElse(null);
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
    public Set<Product> getAll() {
        return productDB;
    }
}