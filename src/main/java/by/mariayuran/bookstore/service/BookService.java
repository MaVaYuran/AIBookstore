package by.mariayuran.bookstore.service;

import by.mariayuran.bookstore.entity.Book;

import java.util.List;

public interface BookService {
    void save(Book book);

    void update(Book book);

    boolean delete(Integer id);

    Book findById(Integer id);

    List<Book> findAll();
}
