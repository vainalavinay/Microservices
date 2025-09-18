package com.microservice.employee.controller;

import com.microservice.employee.entity.EmployeeResponse;
import com.microservice.employee.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController
{
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees/{id}")
    public ResponseEntity<EmployeeResponse> getEmployeeDetails(@PathVariable int id)
    {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getEmployeeDetails(id));
    }

}
