package com.microservice.address.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AddressConfig 
{
	@Bean
	ModelMapper modelMapper()
	{
		return new ModelMapper();
	}
}
