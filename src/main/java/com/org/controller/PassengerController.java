package com.org.controller;

import com.org.exceptions.RecordAlreadyPresentException;
import com.org.exceptions.RecordNotFoundException;
import com.org.model.Passenger;
import com.org.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@ComponentScan(basePackages = "com")
@RestController
@RequestMapping("/passenger")
@CrossOrigin(origins = "https://localhost:4200")
public class PassengerController {
        @Autowired
        PassengerService passengerService;


        @PostMapping("/createPassenger")
        @ExceptionHandler(RecordAlreadyPresentException.class)
        public ResponseEntity<String> addPassenger(@RequestBody Passenger newPassenger) {

            passengerService.createPassenger(newPassenger);
            return new ResponseEntity<String>("Passenger Created Successfully!", HttpStatus.CREATED);
        }


        @PutMapping("/updatePassenger")
        @ExceptionHandler(RecordNotFoundException.class)
        public ResponseEntity<String> updatePassenger(@RequestBody Passenger updatePassenger) {

            passengerService.updatePassenger(updatePassenger);
            return new ResponseEntity<String>("Updated Passenger Successfully!", HttpStatus.CREATED);

        }
    @DeleteMapping("/deletePassenger/{pnr}")
    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<String> deleteBookingByID(@PathVariable("pnr") BigInteger pnrNumber) {

        passengerService.deletePassenger(pnrNumber);
        return new ResponseEntity<String>("Deleted Passenger Successfully!", HttpStatus.CREATED);
    }
//

        @GetMapping("/readAllPassengers")
        public Iterable<Passenger> readAllUsers() {

            return passengerService.displayAllPassenger();
        }
//        @GetMapping("/searchUser/{id}")
//        @ExceptionHandler(RecordNotFoundException.class)
//        public ResponseEntity<?> searchUserByID(@PathVariable("id") BigInteger userId) {
//
//            return userService.findUserById(userId);
//
//        }




    //}
}