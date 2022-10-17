package com.infosys.infygo.ticket;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TicketApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicketApplication.class, args);
	}
	// ModelMapper
		@Bean 
		public ModelMapper modelMapper() {
			return new ModelMapper();
			
		}

}
