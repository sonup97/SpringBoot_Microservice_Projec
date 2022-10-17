package com.infosys.infygo.ticket.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ticket_details")
public class Ticket {

	@Id
	@Column(nullable = false, length = 28)
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer pnr;
	@Column(nullable = false, length = 15)
	private String bookingDate;
	@Column(nullable = false, length = 15)
	private String departureDate;
	@Column(nullable = false, length = 10)
	private String departureTime;
	@Column(nullable = false, length = 10)
	private Double totalFare;
	@Column(nullable = false, length = 20)
	private String flightId;
	@Column(nullable = false, length = 20)
	private String userId; 
	@Column(nullable = false)
	private int noOfSeats;

//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name = "ticket_pnr")
//	private Set<Passenger> ticket_pnr;

	public Integer getPnr() {
		return pnr;
	}

	public void setPnr(Integer pnr) {
		this.pnr = pnr;
	}

	public String getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}

	public String getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public Double getTotalFare() {
		return totalFare;
	}

	public void setTotalFare(Double totalFare) {
		this.totalFare = totalFare;
	}

	public String getFlightId() {
		return flightId;
	}
	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	@Override
	public String toString() {
		return "TicketDTO [pnr=" + pnr + ", bookingDate=" + bookingDate + ", departureDate=" + departureDate
				+ ", departureTime=" + departureTime + ", totalFare=" + totalFare + ", flightId=" +
				// flightId+ ", userId=" + userId+
				", noOfSeats=" + noOfSeats + "]";
	}

//	public Set<Passenger> getTicket_pnr() {
//		return ticket_pnr;
//	}
//
//	public void setTicket_pnr(Set<Passenger> ticket_pnr) {
//		this.ticket_pnr = ticket_pnr;
//	}

}
