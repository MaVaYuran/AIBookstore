package by.mariayuran.bookstore.service;

import by.mariayuran.bookstore.entity.Order;

public interface OrderService {
    Order getOrderById(int id);
    boolean completeOrder(int id);
    boolean cancelOrder(int id);
}
