package com.org.controller;

import com.org.exceptions.RecordAlreadyPresentException;
import com.org.exceptions.RecordNotFoundException;
import com.org.model.ScheduledFlight;
import com.org.service.ScheduledFlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
@ComponentScan(basePackages = "com")
@RestController
@RequestMapping("/scheduledFlight")
@CrossOrigin(origins="https://localhost:4200")
public class ScheduledFlightController {

    @Autowired
    ScheduledFlightService scheduledFlightService;
    @PostMapping("/add")
    @ExceptionHandler(RecordAlreadyPresentException.class)
    public ResponseEntity<String> addScheduledFlight(@RequestBody ScheduledFlight scheduledFlight) {

        scheduledFlightService.addScheduledFlight(scheduledFlight);
        return new ResponseEntity<String>("Scheduled Flight added successfully!", HttpStatus.CREATED);
    }

    @GetMapping("/viewAll")
    public Iterable<ScheduledFlight> viewAllScheduledFlights() {

        return scheduledFlightService.viewAllScheduledFlights();
    }



    @GetMapping("/search/{id}")
    @ExceptionHandler(RecordNotFoundException.class)
    public ScheduledFlight searchByID(@PathVariable("id") BigInteger scheduledFlightId) {

        return scheduledFlightService.viewScheduledFlight(scheduledFlightId);

    }

    @DeleteMapping("/delete/{id}")
    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<String> deleteBookingByID(@PathVariable("id") BigInteger scheduledFlightId) {

        scheduledFlightService.removeScheduledFlight(scheduledFlightId);
        return new ResponseEntity<String>("Deleted scheduled flight Successfully!", HttpStatus.CREATED);
    }
}
