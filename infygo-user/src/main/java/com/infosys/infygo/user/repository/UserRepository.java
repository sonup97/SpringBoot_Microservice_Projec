package com.infosys.infygo.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.infosys.infygo.user.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
	User findByUserId(String userId);

}
