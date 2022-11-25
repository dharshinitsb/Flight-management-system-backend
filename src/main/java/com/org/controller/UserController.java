package com.org.controller;

import java.math.BigInteger;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import org.springframework.web.bind.annotation.*;

import com.org.exceptions.RecordAlreadyPresentException;
import com.org.exceptions.RecordNotFoundException;
import com.org.model.Users;
import com.org.service.UserService;


@ComponentScan(basePackages = "com")
@RestController
@RequestMapping("/user")
@CrossOrigin(origins="https://localhost:4200")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/createUser")
	@ExceptionHandler(RecordAlreadyPresentException.class)
	public ResponseEntity<String> addUser(@RequestBody Users newUser) {

		userService.createUser(newUser);
        return new ResponseEntity<String>("User Created Successfully!", HttpStatus.CREATED);
	}

	@GetMapping("/readAllUsers")
	public Iterable<Users> readAllUsers() {

		return userService.displayAllUser();
	}

	@PutMapping("/updateUser")
	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<String> updateUser(@RequestBody Users updateUser) {

		userService.updateUser(updateUser);
		return new ResponseEntity<String>("Updated User Successfully!", HttpStatus.CREATED);

	}

	@GetMapping("/searchUser/{id}")
	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<?> searchUserByID(@PathVariable("id") BigInteger userId) {

		return userService.findUserById(userId);

	}

	@DeleteMapping("/deleteUser/{id}")
	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<String> deleteBookingByID(@PathVariable("id") BigInteger userId) {

		userService.deleteUser(userId);
		return new ResponseEntity<String>("Deleted User Successfully!", HttpStatus.CREATED);
	}



}