package by.mariayuran.bookstore.servlets;

import by.mariayuran.bookstore.entity.Order;
import by.mariayuran.bookstore.service.OrderService;
import by.mariayuran.bookstore.service.OrderServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/complete")
public class CompleteServlet extends AppServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("id");
        Order order = orderService.getOrderById(Integer.parseInt(idStr));
        if (order != null) {
            orderService.completeOrder(order.getId());

            req.setAttribute("order", order);
            req.setAttribute("orderDetails", order.getOrderDetails());
            req.getRequestDispatcher("/jsp/complete.jsp").forward(req, resp);

        }
        else{
            req.setAttribute("error", "Order couldn't be completed");
            req.getRequestDispatcher("/jsp/error.jsp").forward(req, resp);
        }
    }
}
