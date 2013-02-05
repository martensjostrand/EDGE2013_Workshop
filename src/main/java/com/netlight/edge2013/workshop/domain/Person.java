package com.netlight.edge2013.workshop.domain;

public class Person {
	
	private final String firstName;
	private final String lastName;
	private  final int age; 
	private final String email;

	private Person(String firstName, String lastName, int age, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}

	/* Don't change the signature of this method. */
	public static Person valueOf(final String firstName, final String lastName, final int age, final String email){
		return new Person(firstName, lastName, age, email);
	}
}
