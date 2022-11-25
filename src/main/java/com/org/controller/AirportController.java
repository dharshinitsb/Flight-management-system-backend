package com.org.controller;

import java.math.BigInteger;
import java.util.List;

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
import com.org.model.Airport;
import com.org.model.Flight;
import com.org.service.AirportService;
import com.org.service.AirportServiceImpl;
@CrossOrigin
@RestController
@RequestMapping("/airport")
public class AirportController {
	@Autowired(required = true)
	AirportService airportService;

	@GetMapping("/viewAirport/{id}")
	@ExceptionHandler(RecordNotFoundException.class)
	public Airport viewAirport(@PathVariable("id") String airportCode) {
		return airportService.viewAirport(airportCode);
	}

	@GetMapping("/allAirport")
	public Iterable<Airport> viewAllAirport() {
		return airportService.viewAllAirport();
	}

	@PostMapping("/addAirport")
	@ExceptionHandler(RecordAlreadyPresentException.class)
	public ResponseEntity<String> addAirport(@RequestBody Airport airport) {
		airportService.addAirport(airport);
		return new ResponseEntity<String>("Airport added Successfully!",HttpStatus.CREATED);
	}

	@PutMapping("/updateAirport")
	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<String> modifyAirport(@RequestBody Airport airport) {
		airportService.modifyAirport(airport);
		return new ResponseEntity<String>("Updated Airport Successfully!", HttpStatus.CREATED);
	}

	@DeleteMapping("/deleteAirport/{id}")
	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<String> removeAirport(@PathVariable("id") String airportCode) {
		airportService.removeAirport(airportCode);
		return new ResponseEntity<String>("Deleted Airport Successfully!",HttpStatus.OK);
	}
}
