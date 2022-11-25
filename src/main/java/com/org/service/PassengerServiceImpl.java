package com.org.service;

import com.org.dao.PassengerDao;
import com.org.exceptions.RecordAlreadyPresentException;
import com.org.exceptions.RecordNotFoundException;
import com.org.model.Passenger;
import com.org.model.Users;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Optional;

@Service
@Slf4j
public class PassengerServiceImpl implements PassengerService {
    @Autowired
    PassengerDao passengerDao;
    @Override
    public ResponseEntity<?> createPassenger(Passenger newPassenger) {
        // TODO Auto-generated method stub
        Optional<Passenger> findUserById = passengerDao.findById(newPassenger.getPnrNumber());
        try {
            if (!findUserById.isPresent()) {
                passengerDao.save(newPassenger);
                return new ResponseEntity<Passenger>(newPassenger, HttpStatus.OK);
            } else
                throw new RecordAlreadyPresentException(
                        "User with Id: " + newPassenger.getPnrNumber() + " already exists!!");
        } catch (RecordAlreadyPresentException e) {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Passenger updatePassenger(Passenger updatePassenger) {
        // TODO Auto-generated method stub
        Optional<Passenger> findUserById = passengerDao.findById(updatePassenger.getPnrNumber());
        if (findUserById.isPresent()) {
            passengerDao.save(updatePassenger);
        } else
            throw new RecordNotFoundException(
                    "User with Id: " + updatePassenger.getPnrNumber() + " not exists!!");
        return updatePassenger;
    }

    @Override
    public String deletePassenger(BigInteger pnrNumber) {
        // TODO Auto-generated method stub
        Optional<Passenger> findBookingById = passengerDao.findById(pnrNumber);
        if (findBookingById.isPresent()) {
            passengerDao.deleteById(pnrNumber);
            return "Passenger Deleted!!";
        } else
            throw new RecordNotFoundException("Passenger not found for the entered Pnr Number");
    }

    @Override
    public Iterable<Passenger> displayAllPassenger() {
        // TODO Auto-generated method stub
        return passengerDao.findAll();
    }
//
//    @Override
//    public ResponseEntity<?> findUserById(BigInteger userId) {
//        // TODO Auto-generated method stub
//        Optional<Users> findById = userDao.findById(userId);
//        try {
//            if (findById.isPresent()) {
//                Users findUser = findById.get();
//                return new ResponseEntity<Users>(findUser, HttpStatus.OK);
//            } else
//                throw new RecordNotFoundException("No record found with ID " + userId);
//        } catch (RecordNotFoundException e) {
//            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
//        }
//    }


}
