package com.infosys.infygo.user.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.infygo.user.dto.UserDTO;
//import com.infosys.infygo.user.exceptions.NoUserException;
import com.infosys.infygo.user.service.UserService;

@RestController
@RequestMapping("/users")
@Validated
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping(value = "/register", consumes = "application/json")
	public ResponseEntity<String> createUser(@Valid @RequestBody UserDTO userDTO) {//throws NoUserException{
		return ResponseEntity.ok(userService.createUser(userDTO));
	}

	@PostMapping(value = "/login")
	public ResponseEntity<String> fetchUserById(@RequestBody UserDTO userDTO) {//throws NoUserException{
		return ResponseEntity.ok(userService.fetchUser(userDTO.getUserId(), userDTO.getPassword()));
	}
}
