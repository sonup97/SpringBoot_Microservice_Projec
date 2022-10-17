package com.infosys.infygo.ticket.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.infosys.infygo.ticket.dto.FlightDTO;
import com.infosys.infygo.ticket.dto.PassengerDTO;
import com.infosys.infygo.ticket.entity.Ticket;
import com.infosys.infygo.ticket.repository.TicketRepository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;


@Service
public class TicketService {
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	private TicketRepository ticketDetailsRepository;
	
	@Autowired
	TicketCircuitBreakerService circuitBreaker;

	@CircuitBreaker(name = "TicketService",fallbackMethod="bookPassengersTicketFallMethod")
	public String bookPassengersTicket(String flightId, String userId, List<PassengerDTO> passengerList) throws URISyntaxException {
		System.out.println("In Actual method");

		// Generating PNR for the Tickets
		int noOfPassengers = passengerList.size();
		int randomPnr = 0;
		
		Ticket ticketEntity = new Ticket();

		//FlightDTO flightDTO=restTemplate.getForObject("http://localhost:9200"+"/flights/allFlight/"+flightId, FlightDTO.class);
		//FlightDTO flightDTO=restTemplate.getForObject("http://FlightMS"+"/flights/allFlight/"+flightId, FlightDTO.class);
		FlightDTO flightDTO=circuitBreaker.getSpecificFlights(flightId);
		ticketEntity.setFlightId(flightId);
		ticketEntity.setUserId(userId);

		Double totalfare = passengerList.size() * flightDTO.getFare();
		System.out.println("Totalfare = "+ totalfare);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		URI uri = new URI("http://PassengerMS"+"/passenger/allPassenger");

		if (flightDTO.getSeatCount() > noOfPassengers) {
			flightDTO.setSeatCount(flightDTO.getSeatCount() - noOfPassengers);
			Random rand = new Random();
			randomPnr = 1000 + rand.nextInt(999999);
			for (PassengerDTO pDetailsDTO : passengerList) {
				HttpEntity<PassengerDTO> httpEntity = new HttpEntity<>(pDetailsDTO, headers);
				pDetailsDTO.setPnr(randomPnr);
				restTemplate.postForObject(uri, httpEntity, PassengerDTO.class);
			}

			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			ticketEntity.setPnr(randomPnr);
			ticketEntity.setDepartureDate(flightDTO.getFlightAvailableDate().toString());
			ticketEntity.setBookingDate(formatter.format(new Date()));
			ticketEntity.setDepartureTime(flightDTO.getDepartureTime());
			ticketEntity.setFlightId(flightId);
			ticketEntity.setNoOfSeats(noOfPassengers);
			ticketEntity.setTotalFare(totalfare);
			ticketEntity.setUserId(userId);
			ticketDetailsRepository.save(ticketEntity);

		}


		return "Ticket Booked successfully. Your PNR is: " + ticketEntity.getPnr();

	}
	
	public String bookPassengersTicketFallMethod(String flightId, String userId, List<PassengerDTO> passengerListy,Throwable throwable)  {
		System.out.println("In Fallback method");
		return userId;
		
	}

}
