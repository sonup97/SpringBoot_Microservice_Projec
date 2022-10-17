package com.infosys.infygo.ticket.controller;

import java.net.URISyntaxException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.infosys.infygo.ticket.dto.PassengerDTO;
import com.infosys.infygo.ticket.service.TicketService;

//import com.infygo.dto.PassengerDTO;
//import com.infygo.dto.TicketDTO;
//import com.infygo.exceptions.BookingErrorException;
//import com.infygo.service.TicketService;

@RestController
@RequestMapping("/book")
@Validated
public class TicketController {
	
	

	@Autowired
	private TicketService ticketDetailsService;

	
	@PostMapping(value = "/{flightId}/{userId}", consumes = "application/json")
	public ResponseEntity<String> bookFlight(@PathVariable("flightId") String flightId,
			@PathVariable("userId") String userId, @Valid @RequestBody List<PassengerDTO> passengerList) throws URISyntaxException{// throws BookingErrorException {

		
		return ResponseEntity.ok(ticketDetailsService.bookPassengersTicket(flightId, userId, passengerList));

	}

}
