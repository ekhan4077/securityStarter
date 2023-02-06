package com.example.masaiSecurityApp.employee;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDao extends JpaRepository<Employee, Integer> {

	public Optional<Employee> findByUserName(String username);
}
