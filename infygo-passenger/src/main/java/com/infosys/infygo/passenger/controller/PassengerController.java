package com.infosys.infygo.passenger.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.infosys.infygo.passenger.dto.PassengerDTO;
import com.infosys.infygo.passenger.service.PassengerService;

@RestController
@RequestMapping("/passenger")
@CrossOrigin
public class PassengerController {

	Log logger = LogFactory.getLog(PassengerController.class);

	@Autowired
	PassengerService passengerService;
	
	//"/allPassenger/{passengerId}/{passengerName}/{passengerAge}/{passengerGender}" 

	// Create Friend Family
//	@PostMapping(value = "/allPassenger/{passengerId}/{passengerName}/{passengerAge}/{passengerGender}/{randomPnr}",  consumes = MediaType.APPLICATION_JSON_VALUE)
//	public void savePassenger(@PathVariable("passengerId") int id,@PathVariable("passengerName") String name,
//			@PathVariable("passengerAge") int age,@PathVariable("passengerGender") String gender, @PathVariable("randomPnr") int pnr) {
//		passengerService.savePassenger(id,name,age,gender,pnr);
//	}

	@PostMapping(value = "/allPassenger",  consumes = MediaType.APPLICATION_JSON_VALUE)
	public void savePassenger(@RequestBody PassengerDTO passenger, UriComponentsBuilder builderString) {
		
		passengerService.addPassenger(passenger);
		
	}

}
