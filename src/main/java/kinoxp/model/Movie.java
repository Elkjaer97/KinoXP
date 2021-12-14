package kinoxp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

//@Entity defines this class as a table in the database -- Via JPA
@Entity
public class Movie {

    @Id //Declares that THIS is the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //@GeneratedValue declares that THIS will auto-generate AND GenerationType.IDENTITY declares that THIS will auto-increment
    private int movieId; //The @Id and @GenerationValue is applied to this variable

    //Other columns in the table
    private String name;
    private String description;
    private int playTime;
    private String actors;
    private int ageReq;
    private String genre;
    private int price;

    //Connection via foreign-key to another table
    @OneToMany //Declares the kind of connection to another table
    @JoinColumn(name = "movie_id") //Declares which key the foreign-key is connected to
    @JsonBackReference //Is needed for a "bidirectional-relationship" between two tables
    private Set<Showing> showings = new HashSet<>(); //This column is defined as a collection, since it can have many of them


    //Constructor, Getters, Setters -- Needed for the framework to function probably
    public Movie() {
    }

    public Movie(String name, String description, int playTime, String actors, int ageReq, String genre, int price) {
        this.name = name;
        this.description = description;
        this.playTime = playTime;
        this.actors = actors;
        this.ageReq = ageReq;
        this.genre = genre;
        this.price=price;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPlayTime() {
        return playTime;
    }

    public void setPlayTime(int playTime) {
            this.playTime = playTime;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public int getAgeReq() {
        return ageReq;
    }

    public void setAgeReq(int ageReq) {
        this.ageReq = ageReq;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Set<Showing> getShowings() {
        return showings;
    }

    public void setShowings(Set<Showing> showings) {
        this.showings = showings;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}