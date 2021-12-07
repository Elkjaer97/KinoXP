package kinoxp.controller;

import kinoxp.model.Booking;
import kinoxp.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @PutMapping("/update/{bookingId}")
    public ResponseEntity<Booking> updateBooking(@PathVariable int bookingId, @RequestBody Booking updatedBooking){

        Optional<Booking> optionalObj = bookingRepository.findById(bookingId);

        Booking myBookObj = optionalObj.get();

        myBookObj.setCustomerEmail(updatedBooking.getCustomerEmail());
        myBookObj.setCustomerNumber(updatedBooking.getCustomerNumber());

        myBookObj = bookingRepository.save(myBookObj);

        return new ResponseEntity<>(myBookObj, HttpStatus.OK);




    }









}