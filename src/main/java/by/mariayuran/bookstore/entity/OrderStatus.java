package by.mariayuran.bookstore.entity;

public enum OrderStatus {
    OPEN, COMPLETED, CANCELLED;

    public OrderStatus fromString(String status) {
        return OrderStatus.valueOf(status.toUpperCase());
    }
}
