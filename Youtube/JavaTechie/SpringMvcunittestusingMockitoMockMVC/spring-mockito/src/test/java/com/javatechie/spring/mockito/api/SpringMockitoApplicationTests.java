package com.javatechie.spring.mockito.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javatechie.spring.mockito.api.model.Employee;
import com.javatechie.spring.mockito.api.model.Response;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringMockitoApplicationTests {
  private MockMvc mockMvc;

  /* Now using the smog mvc, we can call the perform method that is post food. What we need.  */

  // To interact with our controllers

  @Autowired
  private WebApplicationContext context;

  /* Now writing insulin methods where we can insulate our mockingbc. Make a command set up anything you can mention here. And I want to initialize this mock mdc before load. Make this class. So for that, I should write the annotation before deprovided by J. Okay. So here we need to initialize our mock image.  */

  ObjectMapper om = new ObjectMapper();

  @Before
  public void setUp() {
    mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
  }

  @Test
  public void addEmployeeTest() throws Exception {
    Employee employee = new Employee();
    employee.setName("Basant");
    employee.setDept("IT");
    /* OK now we can't provide the raw fix to the marking. Even from post manual, you can provide the raw object of employees so that we need to combine by the Jason or string Jason Kernel. So for that, I am using your object marker. People are using object mapper and gsum. One more class is there provided by the Google. So I am using her object mapper. So using the subject matter, I can convert my employee object to string Show string JSM request Tell me about the method name also self explanatory write value as team. Add any object it will comfort in the Json Street.  */
    String jsonRequest = om.writeValueAsString(employee);
    MvcResult result = mockMvc
      .perform(
        post("/EmployeeService/addEmployee")
          .content(jsonRequest)
          .contentType(MediaType.APPLICATION_JSON_VALUE)
      )
      .andExpect(status().isOk())
      .andReturn();
    String resultContent = result.getResponse().getContentAsString();
    Response response = om.readValue(resultContent, Response.class);
    Assert.assertTrue(response.isStatus() == Boolean.TRUE);
  }

  @Test
  public void getEmployeesTest() throws Exception {
    MvcResult result = mockMvc
      .perform(
        get("/EmployeeService/getEmployees")
          .content(MediaType.APPLICATION_JSON_VALUE)
      )
      .andExpect(status().isOk())
      .andReturn();
    String resultContent = result.getResponse().getContentAsString();
    Response response = om.readValue(resultContent, Response.class);
    Assert.assertTrue(response.isStatus() == Boolean.TRUE);
  }
}
