package com.springmvc.demo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



public class Customer {

	private String FirstName;
	private String LastName;
	
	@NotNull(message="is required")
	@Size(min=1)
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
}
