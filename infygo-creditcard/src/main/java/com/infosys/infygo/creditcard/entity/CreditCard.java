package com.infosys.infygo.creditcard.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "creditcard_details")
public class CreditCard {

	@Id
	@Column(nullable = false, length = 20)
	private String cardNumber;
	@Column(nullable = false, length = 30)
	private String cardHolderName;
	@Column(nullable = false, length = 3)
	private String cvv;
	@Column(nullable = false, length = 10)
	private String apin;
	@Column(nullable = false, length = 5)
	private String expiryMonth;
	@Column(nullable = false, length = 4)
	private String expiryYear;
	@Column(nullable = false, length = 20)
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
				+ ", securepin=" + apin + ", expiryMonth=" + expiryMonth + ", expiryYear=" + expiryYear
				+ ", totalBill=" + totalBill + "]";
	}

}
