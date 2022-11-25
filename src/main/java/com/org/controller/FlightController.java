package com.org.controller;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.exceptions.RecordAlreadyPresentException;
import com.org.exceptions.RecordNotFoundException;
import com.org.model.Flight;
import com.org.service.FlightService;
import com.org.service.FlightServiceImpl;
@CrossOrigin
@RestController
@RequestMapping("/flight")
public class FlightController {
	@Autowired(required = true)
	FlightService flightService;

	@PostMapping("/addFlight")
	@ExceptionHandler(RecordAlreadyPresentException.class)
	public ResponseEntity<String> addFlight(@RequestBody Flight flight) {
		flightService.addFlight(flight);
		return new ResponseEntity<String>("Flight added Successfully!", HttpStatus.CREATED);

	}

	@GetMapping("/allFlight")
	public Iterable<Flight> viewAllFlight() {
		return flightService.viewAllFlight();
	}

	@GetMapping("/viewFlight/{id}")
	@ExceptionHandler(RecordNotFoundException.class)
	public Flight viewFlight(@PathVariable("id") BigInteger flightNo) {
		return flightService.viewFlight(flightNo);
	}

	@PutMapping("/updateFlight")
	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<String> modifyFlight(@RequestBody Flight flight) {
		flightService.modifyFlight(flight);
		return new ResponseEntity<String>("Updated Flight Successfully!", HttpStatus.CREATED);

	}

	@DeleteMapping("/deleteFlight/{id}")
	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<String> removeFlight(@PathVariable("id") BigInteger flightNo) {
		flightService.removeFlight(flightNo);
		return new ResponseEntity<String>("Deleted Flight Successfully!", HttpStatus.CREATED);

	}
}
