package com.javatechie.spring.jsondocs.api.service;

import com.javatechie.spring.jsondocs.api.dao.EmployeeRepository;
import com.javatechie.spring.jsondocs.api.model.Employee;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
  @Autowired
  private EmployeeRepository repository;

  public String saveEmployee(Employee employee) {
    repository.save(employee);
    return "new employee added with id :" + employee.getId();
  }

  public Employee getEmployee(int id) {
    return repository.findOne(id);
  }

  public List<Employee> deleteEmployee(int id) {
    repository.delete(id);
    return repository.findAll();
  }
}
