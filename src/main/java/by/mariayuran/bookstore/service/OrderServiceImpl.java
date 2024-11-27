package by.mariayuran.bookstore.service;

import by.mariayuran.bookstore.dao.BookDao;
import by.mariayuran.bookstore.dao.OrderDao;
import by.mariayuran.bookstore.entity.Book;
import by.mariayuran.bookstore.entity.Order;
import by.mariayuran.bookstore.entity.OrderStatus;
import org.hibernate.*;

import java.awt.*;
import java.time.LocalDateTime;


public class OrderServiceImpl implements OrderService {
    private final SessionFactory sessionFactory;
    private final OrderDao orderDao;
    private final BookDao bookDao;

    public OrderServiceImpl(SessionFactory sessionFactory, OrderDao orderDao, BookDao bookDao) {
        this.sessionFactory = sessionFactory;
        this.orderDao = orderDao;
        this.bookDao = bookDao;
    }


    @Override
    public Order getOrderById(int id) {
        Order order = null;
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();

            order = orderDao.findById(id);
            if (order != null) {
                Hibernate.initialize(order.getBooks());
                System.out.println(order.getOrderDetails());
                transaction.commit();
            }
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException(e);
        }
        return order;
    }


    public boolean completeOrder(int id) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Order order = orderDao.findById(id);
            if (order != null) {
                order.setStatus(OrderStatus.COMPLETED);
                order.setClosingTimestamp(LocalDateTime.now());
                orderDao.update(order);
                transaction.commit();
                return true;
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException(e);
        }
        return false;
    }


    public boolean cancelOrder(int id) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Order order = orderDao.findById(id);
            if (order != null) {
                order.setStatus(OrderStatus.CANCELLED);
                order.setClosingTimestamp(LocalDateTime.now());
                orderDao.update(order);
                transaction.commit();
                return true;
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException(e);
        }
        return false;
    }
}
