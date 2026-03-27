package za.ac.cput.Repository;

import za.ac.cput.Domain.Order;

import java.util.List;

public interface IOrderRepository {
    Order create(Order order);
    Order read(String orderId);
    Order update(Order order);
    boolean delete(String orderId);
    List<Order> getAll();
}