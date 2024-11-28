package by.mariayuran.bookstore.servlets;

import by.mariayuran.bookstore.dao.BookDao;
import by.mariayuran.bookstore.dao.BookDaoImpl;
import by.mariayuran.bookstore.dao.OrderDao;
import by.mariayuran.bookstore.dao.OrderDaoImpl;
import by.mariayuran.bookstore.service.OrderService;
import by.mariayuran.bookstore.service.OrderServiceImpl;
import by.mariayuran.bookstore.util.HibernateUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import org.hibernate.SessionFactory;

@WebServlet("/")
public class AppServlet extends HttpServlet {
    protected BookDao bookDao;
    protected OrderDao orderDao;
    protected OrderService orderService;

    public void init() throws ServletException {
        super.init();
        SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
        if (sessionFactory == null) {
            throw new ServletException("SessionFactory is null");
        }
        bookDao = new BookDaoImpl(sessionFactory);
        orderDao = new OrderDaoImpl(sessionFactory);
        orderService = new OrderServiceImpl(orderDao, bookDao);
        if (bookDao == null || orderDao == null || orderService == null) {
            throw new ServletException("DAO or Service initialization failed.");
        }
    }
}
