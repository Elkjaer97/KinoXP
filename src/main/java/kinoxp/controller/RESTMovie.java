package kinoxp.controller;


import kinoxp.model.Movie;
import kinoxp.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController //Defines that this class is a RESTController -- REST combines "@Controller" + "@ResponseBody"
                //Every request handling method of the controller class automatically serializes return objects into HttpResponse

@CrossOrigin    //CrossOrigin allows the frontend and backend to work together. Normally this action is blocked by the CORS-Policy (Which no one knows what is)

@RequestMapping("/movie") //What you need to type to access methods in this controller -- aka: localhost:8080/movie/<method>
public class RESTMovie {

    @Autowired //Instantiates the object "automatically" -- @Autowired takes care of anything that might come with instantiating an object. -- This is also called a dependency-injection
    MovieRepository movieRepository;

    @PostMapping(value="/save", consumes = "application/json") //POST method which will receive some JSON
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie){ //@RequestBody will receive some JSON and transform it into a Java Object

        movieRepository.save(movie); //The method ".save" takes the Java Object, and inserts it into the database.

        return new ResponseEntity<>(movie, HttpStatus.CREATED); //ResponseEntity can receive any type of data and answer with a HttpStatus
    }


    @GetMapping("/get") //Get method
    public List<Movie> displayMovies(){ //This method wil return a collection

        return movieRepository.findAll(); //The method ".findAll" will return everything found in the database as a collection, in form of JSON
    }


    @PutMapping("/update/{movieId}") //Put method, which can receive different path-variables -- aka localhsot:8080/movie/update/<anything>
    public ResponseEntity<Movie> updateMovie(@PathVariable int movieId, @RequestBody Movie updatedMovie ){ //Path variable is defined as int -- Furthermore a @RequestBody will receive some JSON and transform it into a Java Object

        Optional<Movie> optionalObj = movieRepository.findById(movieId);//The method ".findById" will get a specific row in the database with the selected ID
        //The specific row data is the saved as an optional object
        //Optional is an object that is used, so that even if the returned data has no value, then it will still work

        Movie myObj = optionalObj.get(); //Takes the data from the optional object and saves it as a normal Java Object


        //Overwrite the old object with the data from the new object
        myObj.setName(updatedMovie.getName());
        myObj.setDescription(updatedMovie.getDescription());
        myObj.setPlayTime(updatedMovie.getPlayTime());
        myObj.setActors(updatedMovie.getActors());
        myObj.setAgeReq(updatedMovie.getAgeReq());
        myObj.setGenre(updatedMovie.getGenre());


        myObj = movieRepository.save(myObj); //Save the "updated" old object into the database

        return new ResponseEntity<>(myObj, HttpStatus.OK);
    }



    @DeleteMapping("/delete/{movieId}") //Delete method which can receive a path-variable
    public ResponseEntity<Movie> deleteMovie(@PathVariable int movieId)  { //Path-variable is defined as int

        movieRepository.deleteById(movieId); //The method ".deleteById" looks for the matching ID in the database, and removes the entire row


        return ResponseEntity.ok().build();
    }
}
