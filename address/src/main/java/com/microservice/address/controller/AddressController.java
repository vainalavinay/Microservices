package com.microservice.address.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.address.entity.AddressResponse;
import com.microservice.address.service.AddressService;

@RestController
public class AddressController 
{
	@Autowired
	private AddressService addressService;
	
	@GetMapping("/address/{id}")
	public ResponseEntity<AddressResponse> getAddressDetails(@PathVariable int id)
	{
		return ResponseEntity.status(HttpStatus.OK).body(addressService.getAddressDetails(id));
	}
}
