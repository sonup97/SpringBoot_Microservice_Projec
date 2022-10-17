package com.infosys.infygo.ticket.dto;

import java.time.LocalDate;

import javax.validation.constraints.Future;

//import com.infosys.infygo.flight.entity.Flight;



public class FlightDTO {

	private String flightId;
	private String airlines;
	private String source;
	private String destination;
	private double fare;
	@Future
	private LocalDate flightAvailableDate;
	private String departureTime;
	private String arrivalTime;
	private int seatCount;

	public String getFlightId() {
		return flightId;
	}

	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}

	public String getAirlines() {
		return airlines;
	}

	public void setAirlines(String airlines) {
		this.airlines = airlines;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public double getFare() {
		return fare;
	}

	public void setFare(double fare) {
		this.fare = fare;
	}

	public LocalDate getFlightAvailableDate() {
		return flightAvailableDate;
	}

	public void setFlightAvailableDate(LocalDate flightAvailableDate) {
		this.flightAvailableDate = flightAvailableDate;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public int getSeatCount() {
		return seatCount;
	}

	public void setSeatCount(int seatCount) {
		this.seatCount = seatCount;
	}

	@Override
	public String toString() {
		return "FlightDTO [flightId=" + flightId + ", airlines=" + airlines + ", source=" + source + ", destination="
				+ destination + ", fare=" + fare + ", flightAvailableDate=" + flightAvailableDate + ", departureTime="
				+ departureTime + ", arrivalTime=" + arrivalTime + ", seatCount=" + seatCount + "]";
	}

	// Converts Entity into DTO
//	public static FlightDTO valueOf(Flight flightDetailsEntity) {
//		FlightDTO flightDetailsDTO = new FlightDTO();
//
//		flightDetailsDTO.setFlightId(flightDetailsEntity.getFlightId());
//		flightDetailsDTO.setAirlines(flightDetailsEntity.getAirlines());
//		flightDetailsDTO.setSource(flightDetailsEntity.getSource());
//		flightDetailsDTO.setDestination(flightDetailsEntity.getDestination());
//		flightDetailsDTO.setFare(flightDetailsEntity.getFare());
//		flightDetailsDTO.setFlightAvailableDate(flightDetailsEntity.getFlightAvailableDate());
//		flightDetailsDTO.setDepartureTime(flightDetailsEntity.getDepartureTime());
//		flightDetailsDTO.setArrivalTime(flightDetailsEntity.getArrivalTime());
//		flightDetailsDTO.setSeatCount(flightDetailsEntity.getSeatCount());
//
//		return flightDetailsDTO;
//	}
}
