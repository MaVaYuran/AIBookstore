package by.mariayuran.bookstore.dao;

import by.mariayuran.bookstore.entity.Customer;

import java.util.List;

public interface CustomerDao extends BaseDao<Customer, Integer> {
    void save(Customer customer);
    void update(Customer customer);
    boolean delete(Integer id);
    Customer findById(Integer id);
    List<Customer> findAll();

}
