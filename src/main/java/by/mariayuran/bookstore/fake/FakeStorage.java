package by.mariayuran.bookstore.fake;

import by.mariayuran.bookstore.model.Order;

import java.util.ArrayList;
import java.util.List;

public class FakeStorage {
    private final static FakeStorage storage;

    static {
        storage = new FakeStorage();
    }

    private List<Order> orders;

    private FakeStorage() {
        this.orders = new ArrayList<>();
    }

    public static FakeStorage storage() {
        return storage;
    }
    public List<Order> orders(){
        return orders;
    }
}
