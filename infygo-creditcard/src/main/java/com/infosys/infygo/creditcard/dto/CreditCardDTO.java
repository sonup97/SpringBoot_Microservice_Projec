package com.infosys.infygo.creditcard.dto;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

public class CreditCardDTO {

	@NotNull(message = "{user.card.must}")
	// @NotNull(message = environment.user.card.must;
	@Pattern(regexp = "[A-Za-z0-9]{16}")
	private String cardNumber;
	@NotNull(message = "user.name.must")
	private String cardHolderName;
	@NotNull(message = "user.cvv.must")
	@Pattern(regexp = "[0-9]{3,3}", message = "user.cvv.invalid")
	private String cvv;
	@NotNull(message = "user.pin.must")
	private String apin;
	@NotNull(message = "user.emonth.must")
	//@Pattern(regexp = "[A-Z]{3}")
	@Pattern(regexp = "(JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC)")
	private String expiryMonth;
	@NotNull(message = "user.eyear.must")
	private String expiryYear;
	@NotNull(message = "user.bill.must")
	private String totalBill;

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardHolderName() {
		return cardHolderName;
	}

	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public String getApin() {
		return apin;
	}

	public void setApin(String apin) {
		this.apin = apin;
	}

	public String getExpiryMonth() {
		return expiryMonth;
	}

	public void setExpiryMonth(String expiryMonth) {
		this.expiryMonth = expiryMonth;
	}

	public String getExpiryYear() {
		return expiryYear;
	}

	public void setExpiryYear(String expiryYear) {
		this.expiryYear = expiryYear;
	}

	public String getTotalBill() {
		return totalBill;
	}

	public void setTotalBill(String totalBill) {
		this.totalBill = totalBill;
	}

	@Override
	public String toString() {
		return "CreditCardDTO [cardNumber=" + cardNumber + ", cardHolderName=" + cardHolderName + ", cvv=" + cvv
				+ ", securepin=" + apin + ", expiryMonth=" + expiryMonth + ", expiryYear=" + expiryYear + ", totalBill="
				+ totalBill + "]";
	}

}
