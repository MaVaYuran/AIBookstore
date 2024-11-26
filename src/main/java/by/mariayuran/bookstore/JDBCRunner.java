package by.mariayuran.bookstore;

import by.mariayuran.bookstore.dao.BookDao;
import by.mariayuran.bookstore.dao.BookDaoImpl;
import by.mariayuran.bookstore.dao.OrderDao;
import by.mariayuran.bookstore.dao.OrderDaoImpl;
import by.mariayuran.bookstore.service.OrderService;
import by.mariayuran.bookstore.service.OrderServiceImpl;
import by.mariayuran.bookstore.util.HibernateUtil;
import org.hibernate.SessionFactory;

import java.sql.SQLException;


public class JDBCRunner {
    public static void main(String[] args) throws SQLException {
        final SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
        BookDao bookDao  = new BookDaoImpl(sessionFactory);
        OrderDao orderDao = new OrderDaoImpl(sessionFactory);
        OrderService orderService = new OrderServiceImpl(sessionFactory,orderDao, bookDao);
        orderService.getOrderById(1);
        orderService.completeOrder(2);
        orderService.cancelOrder(3);

    }
}
