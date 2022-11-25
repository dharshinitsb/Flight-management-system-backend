package com.org.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private BigInteger userId;
	//private String userName;
	private String firstName;
	private String lastName;
	private String userEmail;

	private String userPassword;
	private String userAddress;

	private BigInteger userPhone;
	private String userRole;


}

