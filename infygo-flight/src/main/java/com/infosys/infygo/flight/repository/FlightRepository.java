package com.infosys.infygo.flight.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.infosys.infygo.flight.entity.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, String> {
	@Query("SELECT t FROM Flight t WHERE t.source =?1 AND t.destination  =?2 AND t.flightAvailableDate =?3")
	List<Flight> fetchFlightDetails(String source, String destination, LocalDate flightAvailableDate);

	// Finding flight by its Id for booking passengers
	Flight findByFlightId(String flightId);

	@Query("Select (f.source) from Flight f ")
	public Set<String> getAllSources();

	@Query("Select (f.destination) from Flight f ")
	public Set<String> getAllDestinations();
	// Finding flight by its Id for booking passengers

}
