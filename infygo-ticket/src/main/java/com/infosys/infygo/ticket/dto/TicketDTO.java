package com.infosys.infygo.ticket.dto;

import com.infosys.infygo.ticket.entity.Ticket;

public class TicketDTO {

	private String userId;
	private Integer pnr;
	private String bookingDate;
	private String departureDate;
	private String departureTime;
	private Double totalFare;
	private String flightId;
	private int noOfSeats;

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
				+ ", departureTime=" + departureTime + ", totalFare=" + totalFare + ", flightId=" + flightId
				+ ", userId=" + userId + ", noOfSeats=" + noOfSeats + "]";
	}

	public static TicketDTO valueOf(Ticket ticketDetailsEntity) {

		TicketDTO ticketDetailsDTO = new TicketDTO();

		ticketDetailsDTO.setPnr(ticketDetailsEntity.getPnr());
		ticketDetailsDTO.setBookingDate(ticketDetailsEntity.getBookingDate());
		ticketDetailsDTO.setDepartureDate(ticketDetailsEntity.getDepartureDate());
		ticketDetailsDTO.setDepartureTime(ticketDetailsEntity.getDepartureTime());
		ticketDetailsDTO.setTotalFare(ticketDetailsEntity.getTotalFare());
		// ticketDetailsDTO.setFlightId(ticketDetailsEntity.getFlightId());
		// ticketDetailsDTO.setUserId(ticketDetailsEntity.getUserId());
		ticketDetailsDTO.setNoOfSeats(ticketDetailsEntity.getNoOfSeats());

		return ticketDetailsDTO;
	}

}
