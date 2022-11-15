package com.luv2code.springdemo.mvc;

import java.util.LinkedHashMap;

public class Student {
	
	private String firstName;
	private String lastName;
	private String country;
	
	private LinkedHashMap<String, String> countryOptions;
	
//	26. Drop-Down Lists
//
//	code snippet
//	<form:select path="country">
//		<form:option value="Brazil" label="Brazil" />
//		<form:option value="France" label="France" />
//		<form:option value="Germany" label="Germany" />
//		<form:option value="India" label="India" />
//	</form:select>
//
//	Develpment Process
//	1. Updating HTML form
//	2. Update Student class - add getter/setter for new prop
//	3. Update confirmation page
//
//	Read if from a java class
//	Step 1: Define country options in a class
//
//	How to use properties file to load country options
//	Ans: This solution will show you how to place the country options in a props file. The values will no longer be hard coded in the Java code.

	private String favoriteLanguage;
	
	private String[] operatingSystems;
	
	public Student() {
		// populate country options: used ISO country code
		countryOptions = new LinkedHashMap<>();
		
		countryOptions.put("BR", "Brazil");
		countryOptions.put("FR", "France");
		countryOptions.put("DE", "Germany");
		countryOptions.put("IN", "India");
		countryOptions.put("US", "United State of America");
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public LinkedHashMap<String, String> getCountryOptions() {
		return countryOptions;
	}
	public String getFavoriteLanguage() {
		return favoriteLanguage;
	}
	public void setFavoriteLanguage(String favoriteLanguage) {
		this.favoriteLanguage = favoriteLanguage;
	}
	public String[] getOperatingSystems() {
		return operatingSystems;
	}
	public void setOperatingSystems(String[] operatingSystems) {
		this.operatingSystems = operatingSystems;
	}
	
//	How to populate radiobuttons with items from Java class?
//
//			1. Set up the data in your Student class
//			private LinkedHashMap<String, String> favoriteLanguageOptions;
//			In your constructor, populate the data
//			favoriteLanguageOptions = new LinkedHashMap<>();
//			// parameter order: value, display label
//			favoriteLanguageOptions.put("Java", "Java");
//			favoriteLanguageOptions.put("C#", "C#");
//			favoriteLanguageOptions.put("PHP", "PHP");
//			favoriteLanguageOptions.put("Ruby", "Ruby");
//
//			Add getter method
//			public LinkedHashMap<String, String> getFavoriteLanguageOptions(){
//				return favoriteLanguageOptions;
//			}
//
//			2. Reference the data in your form
//			<form:radiobuttons path="favoriteLanguage" item="${student.favoriteLanguageOptions}" />
}
