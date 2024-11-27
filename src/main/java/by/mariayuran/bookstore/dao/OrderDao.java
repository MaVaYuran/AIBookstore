package by.mariayuran.bookstore.dao;

import by.mariayuran.bookstore.entity.Order;
import java.util.List;

public interface OrderDao extends Dao<Order, Integer>{
    void save(Order order);
    void update(Order order);
    boolean delete(Integer id);
    Order findById(Integer id);
    List<Order> findAll();

}
