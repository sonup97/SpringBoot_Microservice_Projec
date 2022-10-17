package com.infosys.infygo.flight.entity;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "flight_details")
public class Flight {

	@Id
	@Column(nullable = false, length = 20)
	private String flightId;
	@Column(nullable = false, length = 30)
	private String airlines;
	@Column(nullable = false, length = 20)
	private String source;
	@Column(nullable = false, length = 20)
	private String destination;
	@Column(precision = 10, scale = 2)
	private double fare;

	@Column(nullable = false)
	private LocalDate flightAvailableDate;
	@Column(nullable = false, length = 15)
	private String departureTime;
	@Column(nullable = false, length = 15)
	private String arrivalTime;
	@Column(nullable = false)
	private int seatCount;

//	@OneToMany(cascade = CascadeType.MERGE)
//	@JoinColumn(name = "flightId")
//	private Set<Ticket> flightid;

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

//	public Set<Ticket> getFlightid() {
//		return flightid;
//	}
//
//	public void setFlightid(Set<Ticket> flightid) {
//		this.flightid = flightid;
//	}

	@Override
	public String toString() {
		return "FlightDTO [flightId=" + flightId + ", airlines=" + airlines + ", source=" + source + ", destination="
				+ destination + ", fare=" + fare + ", flightAvailableDate=" + flightAvailableDate + ", departureTime="
				+ departureTime + ", arrivalTime=" + arrivalTime + ", seatCount=" + seatCount + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(airlines, arrivalTime, departureTime, destination, fare, flightAvailableDate, flightId,
				seatCount, source);
	}
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Flight other = (Flight) obj;
		return Objects.equals(airlines, other.airlines) && Objects.equals(arrivalTime, other.arrivalTime)
				&& Objects.equals(departureTime, other.departureTime) && Objects.equals(destination, other.destination)
				&& Double.doubleToLongBits(fare) == Double.doubleToLongBits(other.fare)
				&& Objects.equals(flightAvailableDate, other.flightAvailableDate)
				&& Objects.equals(flightId, other.flightId) && seatCount == other.seatCount
				&& Objects.equals(source, other.source);
	}
	
	

}
