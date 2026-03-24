package za.ac.cput.Factory;

import za.ac.cput.Domain.Order;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class OrderFactoryTest {

    @Test
    void testCreateOrder() {
        String userId = "user-123";
        List<String> products = Arrays.asList("Laptop", "Mouse");
        double total = 1500.00;

        Order order = OrderFactory.createOrder(userId, products, total);

        assertNotNull(order, "Order object should be created");
        assertNotNull(order.getOrderId(), "Factory should generate a unique Order ID");
        assertEquals(userId, order.getUserId());
        assertEquals(products, order.getProductList());
        assertEquals(total, order.getTotalAmount(), 0.001);
    }
}