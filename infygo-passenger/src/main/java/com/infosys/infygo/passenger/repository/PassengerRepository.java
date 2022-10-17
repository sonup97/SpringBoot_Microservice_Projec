package com.infosys.infygo.passenger.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infosys.infygo.passenger.entity.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Integer> {

}
