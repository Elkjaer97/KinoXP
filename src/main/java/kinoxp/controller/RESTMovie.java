package kinoxp.controller;


import kinoxp.model.Movie;
import kinoxp.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/movie")
public class RESTMovie {

    @Autowired
    MovieRepository movieRepository;

    @PostMapping(value="/save", consumes = "application/json")
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie){

        movieRepository.save(movie);
//Balder er dum?
        return new ResponseEntity<>(movie, HttpStatus.CREATED);
    }
}
