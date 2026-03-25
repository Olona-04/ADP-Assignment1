package za.ac.cput.Repository;

import za.ac.cput.Domain.Product;
import java.util.Set;

public interface IProductRepository {

    Product create(Product product);

    Product read(String productId);

    Product update(Product product);

    boolean delete(String productId);

    Set<Product> getAll();
}