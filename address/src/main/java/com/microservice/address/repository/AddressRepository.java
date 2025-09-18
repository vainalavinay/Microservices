package com.microservice.address.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.microservice.address.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer>
{
	@Query(nativeQuery = true, value = "SELECT a.id, a.lane1, a.lane2, a.zip, a.state, a.employee_id FROM address.address a join employee.employee e on e.id = a.employee_id where a.employee_id = :employeeId;")
	Address findAdressByEmployeeId(@Param(value = "employeeId") int id);
}
