package za.ac.cput.Factory;

import za.ac.cput.Domain.Order;

import java.util.List;
import java.util.UUID;

public class OrderFactory {

    public static Order createOrder(String userId, List<String> productList, double totalAmount) {
        if (userId == null || userId.isEmpty()) {
            return null;
        }

        return new Order.Builder()
                .setOrderId(UUID.randomUUID().toString())
                .setUserId(userId)
                .setProductList(productList)
                .setTotalAmount(totalAmount)
                .build();
    }
}
