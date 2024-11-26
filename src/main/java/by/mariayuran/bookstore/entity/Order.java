package by.mariayuran.bookstore.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "order_t")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @ManyToMany
    private Book book;
    @Column(name = "total_price")
    private double totalPrice;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private OrderStatus status;
    @Column(name = "opening_timestamp")

    private LocalDateTime openingTimestamp;
    @Column(name = "closing_timestamp")
    private LocalDateTime closingTimestamp;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


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

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (id != order.id) return false;
        if (Double.compare(order.totalPrice, totalPrice) != 0) return false;
        if (!Objects.equals(book, order.book)) return false;
        if (!Objects.equals(customer, order.customer)) return false;
        if (status != order.status) return false;
        if (!Objects.equals(openingTimestamp, order.openingTimestamp))
            return false;
        return Objects.equals(closingTimestamp, order.closingTimestamp);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (book != null ? book.hashCode() : 0);
        temp = Double.doubleToLongBits(totalPrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (customer != null ? customer.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (openingTimestamp != null ? openingTimestamp.hashCode() : 0);
        result = 31 * result + (closingTimestamp != null ? closingTimestamp.hashCode() : 0);
        return result;
    }

    public String getOrderDetails() {
        return "Order{" + "id=" + id +
               ", Book=" + book.getTitle() + " : price " + book.getPrice() +
               ", status=" + status +
               ", openingTimestamp=" + openingTimestamp +
               '}';
    }
}
