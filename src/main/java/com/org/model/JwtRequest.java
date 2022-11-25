package com.org.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class JwtRequest implements Serializable {


	private static final long serialVersionUID = 5926468583005150707L;

	//private String username;
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	private String address;
	private String phoneNumber;

}