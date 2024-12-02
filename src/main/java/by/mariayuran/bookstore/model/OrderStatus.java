package by.mariayuran.bookstore.model;

public enum OrderStatus {
    OPEN, COMPLETED, CANCELLED;

    public OrderStatus fromString(String status) {
        return OrderStatus.valueOf(status.toUpperCase());
    }
}
