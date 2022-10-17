package com.infosys.infygo.ticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infosys.infygo.ticket.entity.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, String> {

}
