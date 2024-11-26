package by.mariayuran.bookstore.service;

import by.mariayuran.bookstore.dao.BookDao;
import by.mariayuran.bookstore.entity.Book;

public class BookServiceImpl implements BookService {
private final BookDao bookDao;

    public BookServiceImpl(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public Book findById(Integer id) {
        return bookDao.findById(id);
    }
}
