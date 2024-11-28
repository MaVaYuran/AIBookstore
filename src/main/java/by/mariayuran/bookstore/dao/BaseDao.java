package by.mariayuran.bookstore.dao;

import java.util.List;

public interface BaseDao <T,K>{
    void save(T entity);
    void update (T entity);
    boolean delete(K id);
    T findById(K id);
    List<T> findAll();
}
