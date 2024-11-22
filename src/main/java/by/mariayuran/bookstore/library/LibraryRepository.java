package by.mariayuran.bookstore.library;

import by.mariayuran.bookstore.model.Book;
import by.mariayuran.bookstore.model.Order;

import java.util.List;

public interface LibraryRepository {
    List<Book> loadLibrary();
    void writeOrderToJson(List<Order> orders);
}
