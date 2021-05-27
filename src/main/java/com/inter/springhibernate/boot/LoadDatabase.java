package com.inter.springhibernate.boot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.inter.springhibernate.repositories.TravelRepository;

@Configuration
public class LoadDatabase {

	@Bean
	CommandLineRunner init(TravelRepository repository) {
		return args -> {
			
		};
	}
	
}
