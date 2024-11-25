package by.mariayuran.bookstore;

import by.mariayuran.bookstore.service.OrderService;
import by.mariayuran.bookstore.service.OrderServiceImpl;

import java.sql.SQLException;


public class JDBCRunner {
    public static void main(String[] args) throws SQLException {
        OrderService orderService = new OrderServiceImpl();
        orderService.getOrderById(1);
        orderService.completeOrder(2);
        orderService.cancelOrder(3);

    }
}
