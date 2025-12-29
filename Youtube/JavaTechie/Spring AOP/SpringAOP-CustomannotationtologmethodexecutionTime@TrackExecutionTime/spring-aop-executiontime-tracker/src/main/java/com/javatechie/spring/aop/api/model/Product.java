package com.javatechie.spring.aop.api.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {

    @Id
    private int id;
    private String name;
    private int qty;
    private double price;

    public Product() {
        // default constructor required by JPA
    }

    public Product(int id, String name, int qty, double price) {
        this.id = id;
        this.name = name;
        this.qty = qty;
        this.price = price;
    }

    // getters & setters ...
}
