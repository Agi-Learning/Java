package com.javatechie.spring.cloud.function.api;

import java.util.function.Function;

public class Test implements Function<String, String> {
	
	@Override
	public String apply(String t) {
		return "Serverless functional Programming : example by "+t;
	}
}
