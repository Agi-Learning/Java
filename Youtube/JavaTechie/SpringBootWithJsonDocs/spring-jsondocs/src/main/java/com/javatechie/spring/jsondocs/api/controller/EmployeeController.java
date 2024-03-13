package com.javatechie.spring.jsondocs.api.controller;

import com.javatechie.spring.jsondocs.api.model.Employee;
import com.javatechie.spring.jsondocs.api.service.EmployeeService;
import java.util.List;
import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.annotation.ApiPathParam;
import org.jsondoc.core.pojo.ApiStage;
import org.jsondoc.core.pojo.ApiVisibility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(
  name = "Employee Management System",
  description = "Employee info",
  group = "Management",
  visibility = ApiVisibility.PUBLIC,
  stage = ApiStage.BETA
)
public class EmployeeController {
  @Autowired
  private EmployeeService service;

  // Directly annotate postmaking. But the issue is here in Jason Dogs. It didnt support for these annotation like postmaking, gatemaking, this kind of HDTP method type analysis and it will not support. So that is on disadvantages of this and loss. So for that, we need to write only the request mapping annotation. And there there we need to specify the method.
  @RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
  @ApiMethod(description = "add new employee")
  public String save(@RequestBody Employee employee) {
    return service.saveEmployee(employee);
  }

  @RequestMapping(value = "/getEmployee/{id}", method = RequestMethod.GET)
  @ApiMethod(description = "find employee by id", path = { "id" })
  public Employee getEmployee(
    @PathVariable @ApiPathParam(
      description = "input employee id to get",
      name = "id"
    ) int id
  ) {
    return service.getEmployee(id);
  }

  @RequestMapping(value = "/deleteEmployee/{id}", method = RequestMethod.DELETE)
  @ApiMethod(description = "remove employee by id", path = { "id" })
  public List<Employee> deleteEmployee(
    @PathVariable @ApiPathParam(
      description = "input employee id to delete",
      name = "id"
    ) int id
  ) {
    return service.deleteEmployee(id);
  }
}
