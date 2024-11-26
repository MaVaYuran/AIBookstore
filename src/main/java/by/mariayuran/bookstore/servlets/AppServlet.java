package by.mariayuran.bookstore.servlets;

import by.mariayuran.bookstore.dao.BookDao;
import by.mariayuran.bookstore.dao.BookDaoImpl;
import by.mariayuran.bookstore.dao.OrderDao;
import by.mariayuran.bookstore.dao.OrderDaoImpl;
import by.mariayuran.bookstore.service.OrderService;
import by.mariayuran.bookstore.service.OrderServiceImpl;
import by.mariayuran.bookstore.util.HibernateUtil;
import jakarta.servlet.http.HttpServlet;
import org.hibernate.SessionFactory;

public class AppServlet extends HttpServlet {
    protected BookDao bookDao;
    protected OrderDao orderDao;
    protected OrderService orderService;

    public void init() {
        SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
        bookDao = new BookDaoImpl(sessionFactory);
        orderDao = new OrderDaoImpl(sessionFactory);
        orderService = new OrderServiceImpl(sessionFactory, orderDao, bookDao);
    }
}
