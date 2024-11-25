package by.mariayuran.bookstore.model;

import java.time.LocalDateTime;

public class Order {
    private int id;
    private Book book;
    private double totalPrice;
    private OrderStatus status;
    private LocalDateTime openingTimestamp;
    private LocalDateTime closingTimestamp;


    public Order() {
    }

    public Order(Book book) {

        this.book = book;
        totalPrice += book.getPrice();
        this.openingTimestamp = LocalDateTime.now();
        this.status = OrderStatus.OPEN;

    }

    public Book getBook() {
        return book;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public LocalDateTime getOpeningTimestamp() {
        return openingTimestamp;
    }

    public LocalDateTime getClosingTimestamp() {
        return closingTimestamp;
    }

    public int getId() {
        return id;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public void setClosingTimestamp(LocalDateTime closingTimestamp) {
        this.closingTimestamp = closingTimestamp;
    }

    public String getOrderDetails() {
        return "Order{" + "id=" + id +
               ", Book=" + book.getTitle() + " : price " + book.getPrice() +
               ", status=" + status +
               ", openingTimestamp=" + openingTimestamp +
               '}';
    }
}
