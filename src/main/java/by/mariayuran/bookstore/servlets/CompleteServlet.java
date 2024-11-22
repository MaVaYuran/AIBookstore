package by.mariayuran.bookstore.servlets;

import by.mariayuran.bookstore.model.Order;
import by.mariayuran.bookstore.service.OrderService;
import by.mariayuran.bookstore.service.OrderServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/complete")
public class CompleteServlet extends HttpServlet {
    private OrderService orderService;

    @Override
    public void init() {
        orderService = new OrderServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("id");
        int id = Integer.parseInt(idStr);
         req.setAttribute("id", id);
         req.getRequestDispatcher("/jsp/complete.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
