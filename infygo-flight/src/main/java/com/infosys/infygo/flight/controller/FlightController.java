package com.infosys.infygo.flight.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.infygo.flight.dto.FlightDTO;
import com.infosys.infygo.flight.service.FlightService;
//import com.infosys.infygo.flight.dto.UserDTO;
//import com.infosys.infygo.flight.exceptions.NoFlightFoundException;


@RestController
@RequestMapping("/flights")
@Validated
public class FlightController {

	@Autowired
	FlightService flightDetailsService;

	@PostMapping(value = "/register", consumes = "application/json")
	public ResponseEntity<String> createFlights(@Valid @RequestBody FlightDTO flightDTO) {//throws NoFlightFoundException{
		return ResponseEntity.ok(flightDetailsService.createFlight(flightDTO));
	}

	@GetMapping(value = "/sourcesAll")
	public Set<String> sourceDetails() {
		return flightDetailsService.getAllSources();
	}

	@GetMapping(value = "/destinations")
	public Set<String> destinationsDetails() {
		return flightDetailsService.getAllDestinations();
	}
	
	@GetMapping(value = "/{source}/{destination}/{journeydate}", produces = "application/json")
	public List<FlightDTO> flightDetails(@PathVariable("source") String source,
			@PathVariable("destination") String destination,
			@Valid @PathVariable("journeydate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate flightAvailableDate) {

		return flightDetailsService.fetchFlightDetailsDTO(source, destination, flightAvailableDate);
	}

//	@GetMapping(value = "/{source}/{destination}/{journeydate}", produces = "application/json")
//	public List<FlightDTO> flightDetails(@MatrixVariable("source") String source,
//			@MatrixVariable("destination") String destination,
//			@Valid @MatrixVariable("journeydate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate flightAvailableDate) {
//
//		return flightDetailsService.fetchFlightDetailsDTO(source, destination, flightAvailableDate);
//	}
	
	
	//http://localhost:9200/flights/allFlight/1005
	@GetMapping(value = "/allFlight/{flightId}", produces = "application/json")
	public FlightDTO getSpecificFlights(@PathVariable String flightId)  {
		
		if(flightId.equals("1005")) {
			throw new RuntimeException();
		}
		System.out.println("In Flight Controller");		
		return flightDetailsService.getSpecificFlights(flightId);
	}
	
	

}
