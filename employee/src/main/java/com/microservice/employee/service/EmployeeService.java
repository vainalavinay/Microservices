package com.microservice.employee.service;

import com.microservice.employee.entity.AddressResponse;
import com.microservice.employee.entity.Employee;
import com.microservice.employee.entity.EmployeeResponse;
import com.microservice.employee.repository.EmployeeRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class EmployeeService
{
	@Autowired
	private ModelMapper modelMapper;
	
//	@Autowired
	private RestTemplate restTemplate;

    @Autowired
    private EmployeeRepository employeeRepository;
    
    public EmployeeService(@Value("${application.base.url}") String baseUrl, RestTemplateBuilder restTemplateBuilder)
    {
    	this.restTemplate = restTemplateBuilder.rootUri(baseUrl).build();
    }

    public EmployeeResponse getEmployeeDetails(int id)
    {
        Optional<Employee> employee = employeeRepository.findById(id);
        EmployeeResponse employeeResponse = modelMapper.map(employee, EmployeeResponse.class);
        AddressResponse addressResponse = restTemplate.getForObject("/address/{id}", AddressResponse.class, id);
        employeeResponse.setAddressResponse(addressResponse);
        return employeeResponse;
    }
}
