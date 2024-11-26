package by.mariayuran.bookstore.service;

import by.mariayuran.bookstore.model.Book;
import by.mariayuran.bookstore.model.Order;
import by.mariayuran.bookstore.model.OrderStatus;
import by.mariayuran.bookstore.utils.ConnectionManager;

import java.sql.*;
import java.time.LocalDateTime;


public class OrderServiceImpl implements OrderService {
    private BookService bookService = new BookServiceImpl();
    private static final String FIND_ORDER_BY_ID = """
            SELECT book_id, order_t_id,total_price, status, opening_timestamp 
            FROM book_order_t bo 
            JOIN order_t o ON bo.order_t_id = o.id 
            WHERE o.id = ?;
            """;
    private static final String UPDATE_STATUS_TO_COMPLETED = """
                UPDATE order_t SET status=?, closing_timestamp=? WHERE id =? 
            """;
    private static final String UPDATE_STATUS_TO_CANCELLED = """
                UPDATE order_t SET status=?, closing_timestamp=? WHERE id =? 
            """;

    @Override
    public Order getOrderById(int id) {
        Order order = null;
        try (Connection connection = ConnectionManager.open();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_ORDER_BY_ID)) {
            preparedStatement.setInt(1, id);

            ResultSet result = preparedStatement.executeQuery();
            if (result.next()) {
                int orderId = result.getInt("order_t_id");
                int bookId = result.getInt("book_id");
                double totalPrice = result.getDouble("total_price");
                OrderStatus status = OrderStatus.valueOf(result.getString("status").toUpperCase());
                LocalDateTime openingTime = result.getTimestamp("opening_timestamp").toLocalDateTime();

                Book book = bookService.getBookById(bookId);

                order = new Order(book);
                System.out.println(order.getOrderDetails());
                return order;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        return null;
    }




    public boolean completeOrder(int id) {
        try (Connection connection = ConnectionManager.open();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STATUS_TO_COMPLETED)) {
            preparedStatement.setString(1, OrderStatus.COMPLETED.name());
            preparedStatement.setTimestamp(2, Timestamp.valueOf(LocalDateTime.now()));
            preparedStatement.setInt(3, id);

            int rowsUpdated = preparedStatement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    public boolean cancelOrder(int id) {
        try (Connection connection = ConnectionManager.open();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STATUS_TO_CANCELLED)) {
            preparedStatement.setString(1, OrderStatus.CANCELLED.name());
            preparedStatement.setTimestamp(2, Timestamp.valueOf(LocalDateTime.now()));
            preparedStatement.setInt(3, id);

            int rowsUpdated = preparedStatement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }
}
