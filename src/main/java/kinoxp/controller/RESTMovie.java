package kinoxp.controller;


import aj.org.objectweb.asm.ConstantDynamic;
import kinoxp.model.Movie;
import kinoxp.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/movie")
public class RESTMovie {

    @Autowired
    MovieRepository movieRepository;

        @PostMapping(value="/save", consumes = "application/json")
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie){

        movieRepository.save(movie);

        return new ResponseEntity<>(movie, HttpStatus.CREATED);
    }


    @GetMapping("/get")
    public List<Movie> displayMovies(){

        return movieRepository.findAll();
    }


    @PutMapping("/update/{movieId}")
    public ResponseEntity<Movie> updateMovie(@PathVariable int movieId, @RequestBody Movie updatedMovie ){

        Optional<Movie> optionalObj = movieRepository.findById(movieId);

        Movie myObj = optionalObj.get();


        myObj.setName(updatedMovie.getName());
        myObj.setDescription(updatedMovie.getDescription());
        myObj.setPlayTime(updatedMovie.getPlayTime());
        myObj.setActors(updatedMovie.getActors());
        myObj.setAgeReq(updatedMovie.getAgeReq());
        myObj.setGenre(updatedMovie.getGenre());

        return new ResponseEntity<>(myObj, HttpStatus.OK);
    }



    @DeleteMapping("/delete/{movieId}")
    public ResponseEntity<Movie> deleteMovie(@PathVariable int movieId)  {

        movieRepository.deleteById(movieId);


        return ResponseEntity.ok().build();
    }




}
