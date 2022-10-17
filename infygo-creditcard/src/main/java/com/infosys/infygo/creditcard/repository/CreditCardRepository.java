package com.infosys.infygo.creditcard.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.infosys.infygo.creditcard.entity.CreditCard;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard, String> {
	@Query("SELECT t FROM CreditCard t WHERE t.cardNumber = ?1")
	CreditCard findBycardNumber(String cardNumber);
}
