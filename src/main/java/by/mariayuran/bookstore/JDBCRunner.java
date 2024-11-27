package by.mariayuran.bookstore;

import by.mariayuran.bookstore.dao.BookDao;
import by.mariayuran.bookstore.dao.BookDaoImpl;
import by.mariayuran.bookstore.dao.OrderDao;
import by.mariayuran.bookstore.dao.OrderDaoImpl;
import by.mariayuran.bookstore.entity.Book;
import by.mariayuran.bookstore.entity.Order;
import by.mariayuran.bookstore.service.OrderService;
import by.mariayuran.bookstore.service.OrderServiceImpl;
import by.mariayuran.bookstore.util.HibernateUtil;
import org.hibernate.SessionFactory;

import java.sql.SQLException;


public class JDBCRunner {
    public static void main(String[] args) throws SQLException {
        SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
        BookDao bookDao  = new BookDaoImpl(sessionFactory);
        OrderDao orderDao = new OrderDaoImpl(sessionFactory);
        OrderService orderService = new OrderServiceImpl( orderDao, bookDao);
        Order order = orderService.getOrderById(2);
      order.getOrderDetails();


    }
}
