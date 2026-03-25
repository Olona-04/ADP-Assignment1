package za.ac.cput.Factory;

import za.ac.cput.Domain.Product;

public class ProductFactory {

    public static Product createProduct(String productId, String productName, String description, double price, boolean isAuction) {

        if (productId == null || productId.isEmpty())
            return null;

        if (productName == null || productName.isEmpty())
            return null;

        if (description == null || description.isEmpty())
            return null;

        if (price <= 0)
            return null;

        return new Product.Builder()
                .SetProductId(productId)
                .SetProductName(productName)
                .SetDescription(description)
                .SetPrice(price)
                .SetIsAuction(isAuction)
                .build();
    }
}
