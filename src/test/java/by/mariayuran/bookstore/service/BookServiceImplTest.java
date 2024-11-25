package by.mariayuran.bookstore.service;

import by.mariayuran.bookstore.model.Book;
import by.mariayuran.bookstore.utils.ConnectionManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BookServiceImplTest {
    @Mock
    Connection mockConnection;

    @Mock
    PreparedStatement mockPreparedStatement;

    @Mock
    ResultSet mockResultSet;

    private BookServiceImpl bookService;

    @BeforeEach
    public void setUp() throws SQLException {
        bookService = new BookServiceImpl();
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
    }

    @Test
    public void getBookById_Success() throws SQLException {
        int bookId = 1;

        mockStatic(ConnectionManager.class);
        when(ConnectionManager.open()).thenReturn(mockConnection);

        when(mockResultSet.next()).thenReturn(true);
        when(mockResultSet.getInt("id")).thenReturn(bookId);
        when(mockResultSet.getString("title")).thenReturn("Test book");
        when(mockResultSet.getDouble("price")).thenReturn(5.99);

        Book book = bookService.getBookById(bookId);

        assertNotNull(book);
        assertEquals("Test book", book.getTitle());
        assertEquals(5.99, book.getPrice(), 0.001);
    }

}