package com.infosys.infygo.flight;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

@SpringBootApplication
public class FlightApplication implements WebMvcConfigurer{

	public static void main(String[] args) {
		SpringApplication.run(FlightApplication.class, args);
	}
	// To support matrix parameters
		@Override
		public void configurePathMatch(PathMatchConfigurer configurer) {
			UrlPathHelper urlPathHelper = new UrlPathHelper();
			urlPathHelper.setRemoveSemicolonContent(false);
			configurer.setUrlPathHelper(urlPathHelper);
		}
	// ModelMapper
		@Bean
		public ModelMapper modelMapper() {
			return new ModelMapper();
			
		}

}
