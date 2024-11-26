package by.mariayuran.bookstore.servlets;


import by.mariayuran.bookstore.entity.Book;
import by.mariayuran.bookstore.entity.Order;
import by.mariayuran.bookstore.service.OrderService;
import by.mariayuran.bookstore.service.OrderServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/order")
public class BookOrderServlet extends AppServlet {
    List<Book> storeLibrary;
    @Override
    public void init() {
       storeLibrary  = bookDao.findAll();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("books", storeLibrary);
        req.getRequestDispatcher("/jsp/order.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        Book selectedBook = null;

        for (Book book : storeLibrary) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                selectedBook = book;
                break;
            }
        }

        if (selectedBook != null) {
            Order order = new Order(selectedBook);

            req.setAttribute("order", order);
            req.setAttribute("orderDetails", order.getOrderDetails());
            req.getRequestDispatcher("/jsp/order_details.jsp").forward(req, resp);
        } else {
            req.setAttribute("error", "Book not found");
            req.getRequestDispatcher("/jsp/error.jsp").forward(req, resp);
        }
    }
}
