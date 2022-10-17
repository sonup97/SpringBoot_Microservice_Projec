package com.infosys.infygo.flight.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.infygo.flight.dto.FlightDTO;
//import com.infosys.infygo.flight.dto.UserDTO;
import com.infosys.infygo.flight.entity.Flight;
//import com.infosys.infygo.flight.entity.User;
import com.infosys.infygo.flight.repository.FlightRepository;

@Service
public class FlightService {
	
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private FlightRepository flightDetailsRepository;

	public String createFlight(FlightDTO flightDTO) {
		Flight oldFlight = flightDetailsRepository.findByFlightId(flightDTO.getFlightId());
		if (oldFlight != null) {
			return "Flight already exists!";
		} else {
			Flight fentity = modelMapper.map(flightDTO, Flight.class);
			
		
			flightDetailsRepository.saveAndFlush(fentity);
			return "Flight added Successfully!";
		}
	}

	public List<FlightDTO> fetchFlightDetailsDTO(String source, String destination,LocalDate flightAvailableDate) {

		List<Flight> flightDetailsEntities = flightDetailsRepository.fetchFlightDetails(source,
				destination, flightAvailableDate);

		if (flightDetailsEntities.isEmpty())
			System.out.println("No Direct Flights!");

		List<FlightDTO> flightDetailsDTO = new ArrayList<>();
		for (Flight fDetailsDTO : flightDetailsEntities) {
			flightDetailsDTO.add(FlightDTO.valueOf(fDetailsDTO));
		}

		return flightDetailsDTO;
	}

	public Set<String> getAllSources() {
		return flightDetailsRepository.getAllSources();
	}

	public Set<String> getAllDestinations() {
		return flightDetailsRepository.getAllDestinations();
	}
	
	public List<FlightDTO> getAllPlans() {

		List<Flight> flights = flightDetailsRepository.findAll();
		List<FlightDTO> flightDTOs = new ArrayList<>();

		for (Flight plan : flights) {
			FlightDTO flightDTO = FlightDTO.valueOf(plan);
			flightDTOs.add(flightDTO);
		}

		//logger.info("Plan details : "+planDTOs);
		return flightDTOs;
	}
	
	// Fetch specific plan details
		public FlightDTO getSpecificFlights(String flightId) {
			//logger.info("Plan details : "+ flightId);
			FlightDTO FlightDTO = null;
			Optional<Flight> optFlight = flightDetailsRepository.findById(flightId);
			if (optFlight.isPresent()) {
				Flight plan = optFlight.get();
				FlightDTO = FlightDTO.valueOf(plan);
			}

			return FlightDTO;

		}
}
