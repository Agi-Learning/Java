package com.javatechie.spring.ajax.api.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ServiceResponse<T> {
	private String status;
    private T data;
    private List<Book> bookStore;
    public ServiceResponse(String message, T data) {
        this.status = message;
        this.data = data;
    }
    public ServiceResponse(String message, List<Book> bookStore) {
    	this.status = message;
        this.bookStore = bookStore;
	}  
}
