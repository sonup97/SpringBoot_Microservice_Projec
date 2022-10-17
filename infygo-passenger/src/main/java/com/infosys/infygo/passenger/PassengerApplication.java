package com.infosys.infygo.passenger;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PassengerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PassengerApplication.class, args);
	}
	// ModelMapper
		@Bean
		public ModelMapper modelMapper() {
			return new ModelMapper();
			
		}

}
