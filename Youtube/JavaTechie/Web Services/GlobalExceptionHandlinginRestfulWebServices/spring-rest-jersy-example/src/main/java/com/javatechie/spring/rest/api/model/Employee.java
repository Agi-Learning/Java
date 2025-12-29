package com.javatechie.spring.rest.api.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {

    @Id
    private int id;
    private String name;
    private String dept;

    public Employee() {}

    public Employee(int id, String name, String dept) {
        this.id = id;
        this.name = name;
        this.dept = dept;
    }

    // getters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getDept() { return dept; }

    // setters
    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setDept(String dept) { this.dept = dept; }
}
