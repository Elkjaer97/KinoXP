package kinoxp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookId;

    private String customerEmail;
    private String customerNumber;
    private String customerMovie;

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String cusEmail) {
        this.customerEmail = cusEmail;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String cusNumber) {
        this.customerNumber = cusNumber;
    }
    public String getCustomerMovie() {
        return customerMovie;
    }

    public void setCustomerMovie(String cusMovie) {
        this.customerMovie = cusMovie;
    }

    public Booking() {
    }
}
