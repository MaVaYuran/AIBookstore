package by.mariayuran.bookstore.dao;

import by.mariayuran.bookstore.entity.Book;

import java.util.List;

public interface BookDao extends Dao<Book, Integer>{
    void save(Book book);
    void update(Book book);
    boolean delete(Integer id);
    Book findById(Integer id);
    List<Book> findAll();
}
