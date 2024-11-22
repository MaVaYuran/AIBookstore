package by.mariayuran.bookstore.model;

import java.time.LocalDateTime;

public class Order {
//    private int id;
    private Book book;
    private OrderStatus status;
    private LocalDateTime openingTimestamp;
    private LocalDateTime closingTimestamp;
    private int id;
    private static int ID=0;


    public Order() {
    }
    public Order(Book book) {
        this.id = ++ID;
        this.book = book;
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

    public static int getID() {
        return ID;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public void setClosingTimestamp(LocalDateTime closingTimestamp) {
        this.closingTimestamp = closingTimestamp;
    }

    public String getOrderDetails() {
        return "Order{" +"id=" + id +
               ", Book=" + book.getTitle() +" : price " + book.getPrice() +
               ", status=" + status +
               ", openingTimestamp=" + openingTimestamp +
               '}';
    }


}
