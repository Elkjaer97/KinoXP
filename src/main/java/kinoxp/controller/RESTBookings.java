package kinoxp.controller;

import kinoxp.model.Booking;
import kinoxp.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/show-book")
public class RESTBookings {

    @Autowired
    BookingRepository bookingRepository;

    @PostMapping(value = "/save", consumes = "application/json")
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) {

        bookingRepository.save(booking);

        return new ResponseEntity<>(booking, HttpStatus.CREATED);
    }


    @GetMapping("/get")
    public List<Booking> displayBooking() {


        return bookingRepository.findAll();
    }

    @DeleteMapping("/delete/{bookingId}")
    public ResponseEntity<Booking> deleteBooking(@PathVariable int bookingId) {

        bookingRepository.deleteById(bookingId);


        return ResponseEntity.ok().build();
    }
}