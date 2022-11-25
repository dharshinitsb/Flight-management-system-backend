package com.org.dao;

import com.org.model.Passenger;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
@Repository
public interface PassengerDao extends CrudRepository<Passenger, BigInteger> {
}
