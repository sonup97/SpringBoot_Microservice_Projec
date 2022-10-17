package com.infosys.infygo.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import com.infosys.infygo.user.dto.UserDTO;
import com.infosys.infygo.user.entity.User;
//import com.infosys.infygo.user.exceptions.NoUserException;
import com.infosys.infygo.user.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public String createUser(UserDTO userDTO) {
		User oldUser = userRepository.findByUserId(userDTO.getUserId());
		if (oldUser != null) {
			return "User already registered!";
		} else {
			userRepository.saveAndFlush(userDTO.createEntity());
			return "User added Successfully!";
		}
	}

	public String fetchUser(String username, String password) {//throws NoUserException {
		User user = userRepository.findByUserId(username);
		if (user != null) {
			if (user.getPassword().equals(password)) {
				return "Login Successful! \n Hello " + user.getName() + " welcome to InfyGo. ";
			} else {
				return "Incorrect Password!";
			}
		} 
		else
			return "User not found!";
		
	}

}
