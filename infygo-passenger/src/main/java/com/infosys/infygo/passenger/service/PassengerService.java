package com.infosys.infygo.passenger.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.infygo.passenger.dto.PassengerDTO;
import com.infosys.infygo.passenger.entity.Passenger;
import com.infosys.infygo.passenger.repository.PassengerRepository;

@Service
public class PassengerService {
	Log logger = LogFactory.getLog(PassengerService.class);

	@Autowired
	PassengerRepository passengerRepo;

	// Create Friend Family
	
	public void savePassenger(int id, String name, int age, String gender, int pnr) {
		
		Passenger passenger = new Passenger();
		passenger.setPassengerId(id);
		passenger.setPassengerName(name);
		passenger.setPassengerAge(age);
		passenger.setPassengerGender(gender);
		passenger.setTicket_pnr(pnr);
		passengerRepo.save(passenger);
	}
	
	public void addPassenger(PassengerDTO passenger) {
		Passenger p = new Passenger();
		p.setPassengerId(passenger.getPassengerId());
		p.setPassengerName(passenger.getPassengerName());
		p.setPassengerAge(passenger.getPassengerAge());
		p.setPassengerGender(passenger.getPassengerGender());
		p.setTicket_pnr(passenger.getPnr());
		passengerRepo.save(p);
		
	}

}
