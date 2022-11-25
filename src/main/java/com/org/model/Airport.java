package com.org.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Airport
/**
 * Class Airport
 */
{
	@Id
	private String airportCode;
	private String airportLocation;
	private String airportName;
	private String srcAirport;
	private String dstnAirport;
}


