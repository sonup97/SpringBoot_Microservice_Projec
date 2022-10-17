package com.infosys.infygo.creditcard.controller;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.infygo.creditcard.dto.CreditCardDTO;
import com.infosys.infygo.creditcard.service.CreditCardService;



@RestController
@RequestMapping("/creditcard")
@Validated
public class CreditCardController {
	
	@Autowired
	private CreditCardService cardDetailsService;
	
	@PostMapping(consumes="application/json")
	public ResponseEntity<String> fetchCreditCardDetails(@Valid @RequestBody CreditCardDTO cardDetailsDTO) {//throws NoCardFoundException {
		return ResponseEntity.ok(cardDetailsService.fetchCreditCardDetails(cardDetailsDTO));
	}
	
}
