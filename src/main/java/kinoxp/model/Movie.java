package kinoxp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int movieId;
    private String name;
    private String description;
    private int playTime;
    private String actors;
    private int ageReq;
    private String genre;

    @OneToMany
    @JoinColumn(name = "movie_id")
    @JsonBackReference
    private Set<Showing> showings = new HashSet<>();

    public Movie() {
    }

    public Movie(String name, String description, int playTime, String actors, int ageReq, String genre) {
        this.name = name;
        this.description = description;
        this.playTime = playTime;
        this.actors = actors;
        this.ageReq = ageReq;
        this.genre = genre;
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
}