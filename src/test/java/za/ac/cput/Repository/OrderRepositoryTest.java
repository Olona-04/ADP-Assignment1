package za.ac.cput.Repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.Domain.Order;
import za.ac.cput.Factory.OrderFactory;
import za.ac.cput.repositoryImpl.OrderRepository;

import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class OrderRepositoryTest {
    private static OrderRepository repository = OrderRepository.getRepository();
    private static Order order = OrderFactory.createOrder("user-001", Arrays.asList("Item A"), 100.00);

    @Test
    void a_create() {
        Order created = repository.create(order);
        assertEquals(order.getOrderId(), created.getOrderId());
        System.out.println("Created: " + created.getOrderId());
    }

    @Test
    void b_read() {
        Order read = repository.read(order.getOrderId());
        assertNotNull(read);
        System.out.println("Read: " + read.getOrderId());
    }

    @Test
    void c_update() {
        Order updated = new Order.Builder()
                .setOrderId(order.getOrderId())
                .setUserId(order.getUserId())
                .setProductList(order.getProductList())
                .setTotalAmount(250.00)
                .build();

        assertNotNull(repository.update(updated));
        assertEquals(250.00, repository.read(order.getOrderId()).getTotalAmount());
        System.out.println("Updated amount to: " + updated.getTotalAmount());
    }

    @Test
    void d_delete() {
        boolean success = repository.delete(order.getOrderId());
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }

    @Test
    void e_getAll() {
        System.out.println("Show all: " + repository.getAll());
    }
}