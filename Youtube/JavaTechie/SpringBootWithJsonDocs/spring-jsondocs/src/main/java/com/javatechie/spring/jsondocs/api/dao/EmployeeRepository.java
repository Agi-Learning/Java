package com.javatechie.spring.jsondocs.api.dao;

import com.javatechie.spring.jsondocs.api.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

// I am using gt revisitory here, but some crowd operation I want to show you so that I do not want to write something to integrate with high wallet. Employee repository.

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {}
