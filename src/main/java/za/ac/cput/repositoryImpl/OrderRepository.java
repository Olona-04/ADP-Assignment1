package za.ac.cput.repositoryImpl;

import za.ac.cput.Domain.Order;
import za.ac.cput.Repository.IOrderRepository;
import java.util.ArrayList;
import java.util.List;

public class OrderRepository implements IOrderRepository {
    private static OrderRepository repository = null;
    private List<Order> orderDB;

    private OrderRepository() {
        orderDB = new ArrayList<>();
    }

    public static OrderRepository getRepository() {
        if (repository == null) {
            repository = new OrderRepository();
        }
        return repository;
    }

    @Override
    public Order create(Order order) {
        if (read(order.getOrderId()) == null) {
            orderDB.add(order);
            return order;
        }
        return null;
    }

    @Override
    public Order read(String orderId) {
        for (Order o : orderDB) {
            if (o.getOrderId().equals(orderId)) {
                return o;
            }
        }
        return null;
    }

    @Override
    public Order update(Order order) {
        Order oldOrder = read(order.getOrderId());
        if (oldOrder != null) {
            orderDB.remove(oldOrder);
            orderDB.add(order);
            return order;
        }
        return null;
    }

    @Override
    public boolean delete(String orderId) {
        Order orderToDelete = read(orderId);
        if (orderToDelete != null) {
            return orderDB.remove(orderToDelete);
        }
        return false;
    }

    @Override
    public List<Order> getAll() {
        return orderDB;
    }
}