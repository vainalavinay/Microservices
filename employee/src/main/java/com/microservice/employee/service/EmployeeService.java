package com.microservice.employee.service;

import com.microservice.employee.entity.Employee;
import com.microservice.employee.entity.EmployeeResponse;
import com.microservice.employee.repository.EmployeeRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService
{
	@Autowired
	private ModelMapper modelMapper;

    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeResponse getEmployeeDetails(int id)
    {
        Optional<Employee> employee = employeeRepository.findById(id);
        
        EmployeeResponse employeeResponse = modelMapper.map(employee, EmployeeResponse.class);
        
        return employeeResponse;
    }
}
