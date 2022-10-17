package com.infosys.infygo.passenger.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import com.infosys.infygo.passenger.dto.PassengerDTO;

@Entity
@Table(name = "passenger_details")
public class Passenger {

	@Id
	@GeneratedValue
	private Integer passengerId;
	@Column(nullable = false, length = 30)
	private String passengerName;
	@Column(nullable = false)
	private int passengerAge;
	@Column(nullable = false, length = 8)
	private String passengerGender;
	@Column(length = 12)
	private Integer ticket_pnr;
//	
//	@ManyToOne(cascade=CascadeType.ALL)
//	@JoinColumn(name="ticket_pnr")
//	private TicketDetailsEntity pnr;

	public int getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public int getPassengerAge() {
		return passengerAge;
	}

	public void setPassengerAge(int passengerAge) {
		this.passengerAge = passengerAge;
	}

	public String getPassengerGender() {
		return passengerGender;
	}

	public void setPassengerGender(String passengerGender) {
		this.passengerGender = passengerGender;
	}

	public Integer getTicket_pnr() {
		return ticket_pnr;
	}
	public void setTicket_pnr(Integer ticket_pnr) {
		this.ticket_pnr = ticket_pnr;
	}
	// public TicketDetailsEntity getTicket_pnr() {
//		return pnr;
//	}
//	public void setTicket_pnr(TicketDetailsEntity pnr) {
//		this.pnr = pnr;
//	}
	@Override
	public String toString() {
		return "PassengerDTO [passengerId=" + passengerId + ", passengerName=" + passengerName + ", passengerAge="
				+ passengerAge + ", passengerGender=" + passengerGender + ", pnr=" + "]";
	}

}
