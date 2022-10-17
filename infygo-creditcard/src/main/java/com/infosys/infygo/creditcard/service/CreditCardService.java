package com.infosys.infygo.creditcard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import com.infosys.infygo.creditcard.repository.*;
import com.infosys.infygo.creditcard.dto.CreditCardDTO;
import com.infosys.infygo.creditcard.entity.*;


@Service

public class CreditCardService {

	@Autowired
	private CreditCardRepository creditCardDetailsRepository;

	public String fetchCreditCardDetails(CreditCardDTO creditCardDetailsDTO) {
		CreditCard cardDetailsEntity = creditCardDetailsRepository
				.findBycardNumber(creditCardDetailsDTO.getCardNumber());

		if (cardDetailsEntity == null) {
			return "No details found! Please recheck or add details...";
		} else {
			if ((creditCardDetailsDTO.getCardHolderName().equals(cardDetailsEntity.getCardHolderName()))
					&& (creditCardDetailsDTO.getCvv().equals(cardDetailsEntity.getCvv()))
					&& (creditCardDetailsDTO.getApin().equals(cardDetailsEntity.getApin()))
					&& (creditCardDetailsDTO.getExpiryMonth().equals(cardDetailsEntity.getExpiryMonth()))
					&& (creditCardDetailsDTO.getExpiryYear().equals(cardDetailsEntity.getExpiryYear()))) {

				return "Card details are verified! You can book flights.";
			}

			return "Card details are not correct!";

		}

	}
}
