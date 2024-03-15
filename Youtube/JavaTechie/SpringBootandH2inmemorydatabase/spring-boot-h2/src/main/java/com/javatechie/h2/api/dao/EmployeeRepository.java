package com.javatechie.h2.api.dao;

import com.javatechie.h2.api.model.Employee;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
  List<Employee> findByDept(String dept);
}
