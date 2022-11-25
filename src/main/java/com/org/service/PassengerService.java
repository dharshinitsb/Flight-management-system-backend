package com.org.service;

import com.org.model.Passenger;

import org.springframework.http.ResponseEntity;

import java.math.BigInteger;

public interface PassengerService {
    public ResponseEntity<?> createPassenger(Passenger newPasssenger);

    public Passenger updatePassenger(Passenger newUser);

    public String deletePassenger(BigInteger pnrNumber);

   public Iterable<Passenger> displayAllPassenger();
//
//    public ResponseEntity<?> findUserById(BigInteger userId);
}
