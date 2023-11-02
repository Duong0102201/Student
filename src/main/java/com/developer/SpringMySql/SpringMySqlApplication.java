package com.developer.SpringMySql;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

//@ComponentScan("com.developer.SpringMySql.controllers")
@SpringBootApplication
//@EnableWebMvc
public class SpringMySqlApplication{

	public static void main(String[] args) {
		SpringApplication.run(SpringMySqlApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper;
	}
}
