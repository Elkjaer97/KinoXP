package kinoxp.controller;

import kinoxp.model.Movie;
import kinoxp.model.Showing;
import kinoxp.repositories.MovieRepository;
import kinoxp.repositories.ShowingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/showing")
public class RESTShowing {

    @Autowired
    ShowingRepository showingRepository;

    @PostMapping(value="/save", consumes = "application/json")
    public ResponseEntity<Showing> createShowing(@RequestBody Showing showing){

        System.out.println(showing);
        
        showingRepository.save(showing);

        return new ResponseEntity<>(showing, HttpStatus.CREATED);
    }


    @GetMapping("/get")
    public List<Showing> displayShowing(){

        return showingRepository.findAll();
    }

    @DeleteMapping("/delete/{showingId}")
    public ResponseEntity<Showing> deleteMovie(@PathVariable int showingId)  {

        showingRepository.deleteById(showingId);

        return ResponseEntity.ok().build();
    }

}
