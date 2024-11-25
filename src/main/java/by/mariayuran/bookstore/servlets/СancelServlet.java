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

@WebServlet("/cancel")
public class СancelServlet extends HttpServlet {
    private OrderService orderService;

    @Override
    public void init() {
        orderService = new OrderServiceImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("id");
        Order order = orderService.getOrderById(Integer.parseInt(idStr));
        if (order != null) {
            orderService.cancelOrder(order.getId());

            req.setAttribute("order", order);
            req.setAttribute("orderDetails", order.getOrderDetails());
            req.getRequestDispatcher("/jsp/cancel.jsp").forward(req, resp);

        }
        else{
            req.setAttribute("error", "Order couldn't be completed");
            req.getRequestDispatcher("/jsp/error.jsp").forward(req, resp);
        }
    }
}
