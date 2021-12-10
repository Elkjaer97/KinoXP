package kinoxp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Showing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int showingId;

    private LocalDateTime date;
    private LocalDateTime endDate;
    private int Theater;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @OneToMany
    @JoinColumn(name = "showing_id")
    @JsonBackReference
    private Set<Booking> bookings = new HashSet<>();


    public Showing() {
    }

    public int getShowingId() {
        return showingId;
    }

    public void setShowingId(int showingId) {
        this.showingId = showingId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public int getTheater() {
        return Theater;
    }

    public void setTheater(int theater) {
        Theater = theater;
    }

    public Movie getMovie() { return movie; }

    public void setMovieId(Movie movie) {
        this.movie = movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Set<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(Set<Booking> bookings) {
        this.bookings = bookings;
    }

    public LocalDateTime getEndDate() { return endDate; }

    public void setEndDate(LocalDateTime endDate) { this.endDate = endDate; }

    @Override
    public String toString() {
        return "Showing{" +
                "showingId=" + showingId +
                ", date=" + date +
                ", endDate=" + endDate +
                ", Theater=" + Theater +
                ", movie=" + movie +
                ", bookings=" + bookings +
                '}';
    }
}
