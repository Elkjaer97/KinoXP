package kinoxp.model;

import javax.persistence.*;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookId;

    @ManyToOne
    @JoinColumn(name = "showing_id")
    private Showing showing;


    private String customerEmail;
    private String customerNumber;
    private String customerMovie;


    public Showing getShowing() {
        return showing;
    }

    public void setShowing(Showing showing) {
        this.showing = showing;
    }

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
