package by.mariayuran.bookstore.service;

import by.mariayuran.bookstore.model.Book;
import by.mariayuran.bookstore.utils.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookServiceImpl implements BookService {
    private static final String FIND_BOOK_BY_ID = "SELECT * FROM book WHERE id=?";

    @Override
    public Book getBookById(int id) {
        Book book = null;
        try (Connection connection = ConnectionManager.open();
             PreparedStatement statement = connection.prepareStatement(FIND_BOOK_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int bookId = resultSet.getInt("id");
                String title = resultSet.getString("title");
                double bookPrice = resultSet.getDouble("price");
                book = new Book(title, bookPrice);

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return book;
    }
}
