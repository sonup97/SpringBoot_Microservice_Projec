package com.infosys.infygo.ticket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.infosys.infygo.ticket.dto.FlightDTO;
import com.infosys.infygo.ticket.dto.PassengerDTO;


import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class TicketCircuitBreakerService {

//	@Autowired
//	CustPlanFeign planFeign;
//	
//	@Autowired
//	CustFriendFeign friendFeign;
	
	@Autowired
	RestTemplate restTemplate;
	
	@CircuitBreaker(name = "TicketService")
	public FlightDTO getSpecificFlights(String flightId){
		return restTemplate.getForObject("http://FlightMS"+"/flights/allFlight/"+flightId, FlightDTO.class);
	}

	
//	@CircuitBreaker(name = "PassengerService")
//	public void savePassenger(Integer flightId){
//		return restTemplate.postForObject(uri, httpEntity, PassengerDTO.class);
//	}

}
