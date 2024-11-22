package by.mariayuran.bookstore.service;

import by.mariayuran.bookstore.fake.FakeStorage;
import by.mariayuran.bookstore.model.Order;
import by.mariayuran.bookstore.model.OrderStatus;
import java.time.LocalDateTime;

public class OrderServiceImpl implements OrderService {


    @Override
    public Order getOrderById(int id) {
        return FakeStorage.storage().orders().stream()
                .filter(order -> order.getId() == id)
                .findFirst().orElse(null);
    }

    @Override
    public void addOrder(Order order) {
        FakeStorage.storage().orders().add(order);
    }

    public boolean completeOrder(int id) {
        FakeStorage.storage().orders().stream()
                .filter(order -> order.getId() == id)
                .findFirst()
                .map(order -> {
                    order.setStatus(OrderStatus.COMPLETED);
                    order.setClosingTimestamp(LocalDateTime.now());
                    return true;
                });
        return false;
    }

    public boolean cancelOrder(int id) {
        FakeStorage.storage().orders().stream()
                .filter(order -> order.getId() == id)
                .findFirst()
                .map(order -> {
                    order.setStatus(OrderStatus.CANCELLED);
                    order.setClosingTimestamp(LocalDateTime.now());
                    return true;
                });
        return false;
    }
}
