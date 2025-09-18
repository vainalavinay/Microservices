package com.microservice.address.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.address.entity.Address;
import com.microservice.address.entity.AddressResponse;
import com.microservice.address.repository.AddressRepository;

@Service
public class AddressService 
{
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private AddressRepository addressRepository;
	
	public AddressResponse getAddressDetails(int id)
	{
		Address address = addressRepository.findAdressByEmployeeId(id);
		AddressResponse response = modelMapper.map(address, AddressResponse.class);
		
		return response;
	}
}
