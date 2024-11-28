package by.mariayuran.bookstore.service;

import by.mariayuran.bookstore.dao.BookDao;
import by.mariayuran.bookstore.dao.OrderDao;
import by.mariayuran.bookstore.entity.Order;
import by.mariayuran.bookstore.entity.OrderStatus;
import org.hibernate.*;
import java.time.LocalDateTime;


public class OrderServiceImpl implements OrderService {

    private final OrderDao orderDao;
    private final BookDao bookDao;

    public OrderServiceImpl(OrderDao orderDao, BookDao bookDao) {

        this.orderDao = orderDao;
        this.bookDao = bookDao;
    }


    @Override
    public Order getOrderById(int id) {
        Order order = orderDao.findById(id);
        if (order != null) {
            Hibernate.initialize(order.getBooks());
            System.out.println(order.getOrderDetails());
            return order;
        }
        return null;
    }

        public boolean completeOrder ( int id){
            Order order = orderDao.findById(id);
            if (order != null) {
                order.setStatus(OrderStatus.COMPLETED);
                order.setClosingTimestamp(LocalDateTime.now());
                orderDao.update(order);

                return true;
            }
            return false;
        }


        public boolean cancelOrder ( int id){
            Order order = orderDao.findById(id);
            if (order != null) {
                order.setStatus(OrderStatus.CANCELLED);
                order.setClosingTimestamp(LocalDateTime.now());
                orderDao.update(order);
                return true;
            }
            return false;
        }
    }
