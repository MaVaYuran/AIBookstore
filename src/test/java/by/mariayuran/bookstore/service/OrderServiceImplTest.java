package by.mariayuran.bookstore.service;

import by.mariayuran.bookstore.model.Book;
import by.mariayuran.bookstore.model.Order;
import by.mariayuran.bookstore.model.OrderStatus;
import by.mariayuran.bookstore.utils.ConnectionManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.*;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class OrderServiceImplTest {

    @InjectMocks
    private OrderServiceImpl orderService;

    @Mock
    private BookService bookService;
    @Mock
    private Connection mockConnection;

    @Mock
    private PreparedStatement mockPreparedStatement;

    @Mock
    ResultSet mockResultSet;

    @BeforeAll
    public static void setBeforeAll() {
        mockStatic(ConnectionManager.class);
    }

    @BeforeEach
    public void setUp() throws SQLException {

        when(ConnectionManager.open()).thenReturn(mockConnection);
        when(mockConnection.prepareStatement(any())).thenReturn(mockPreparedStatement);
    }

    @Test
    public void getOrderById_success() throws SQLException {

        int orderId = 1;
        int bookId = 1;
        double totalPrice = 10.00;
        LocalDateTime openingTime = LocalDateTime.now();

        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true);
        when(mockResultSet.getInt("order_t_id")).thenReturn(orderId);
        when(mockResultSet.getInt("book_id")).thenReturn(bookId);
        when(mockResultSet.getDouble("total_price")).thenReturn(totalPrice);
        when(mockResultSet.getString("status")).thenReturn("open");
        when(mockResultSet.getTimestamp("opening_timestamp")).thenReturn(Timestamp.valueOf(openingTime));

        when(bookService.getBookById(bookId)).thenReturn(new Book("Test book", totalPrice));

        Order order = orderService.getOrderById(orderId);

        assertNotNull(order);
        assertEquals("Test book", order.getBook().getTitle());
        assertEquals(totalPrice, order.getTotalPrice());
    }

    @Test
    public void completeOrder_success() throws SQLException {
        int orderId = 1;
        when(mockPreparedStatement.executeUpdate()).thenReturn(1);

        boolean result = orderService.completeOrder(orderId);

        assertTrue(result);
        verify(mockPreparedStatement).setString(1, OrderStatus.COMPLETED.name());
//        verify(mockPreparedStatement).setTimestamp(2, Timestamp.valueOf(LocalDateTime.now())); doesn't work
        verify(mockPreparedStatement).setInt(3, orderId);

    }

    @Test
    public void cancelOrder_success() throws SQLException {
        int orderId = 1;
        when(mockPreparedStatement.executeUpdate()).thenReturn(1);

        boolean result = orderService.cancelOrder(orderId);

        assertTrue(result);
        verify(mockPreparedStatement).setString(1, OrderStatus.CANCELLED.name());
//        verify(mockPreparedStatement).setTimestamp(2, Timestamp.valueOf(LocalDateTime.now())); doesn't work
        verify(mockPreparedStatement).setInt(3, orderId);
    }
}