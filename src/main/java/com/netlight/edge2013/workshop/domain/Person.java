package com.netlight.edge2013.workshop.domain;

public class Person implements Comparable<Person> {
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

	public int getAge(){
		return age;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public int compareTo(final Person that) {
		int result = this.lastName.compareTo(that.lastName);
		if(result == 0){
			result = this.firstName.compareTo(that.firstName);
		}

		if(result == 0){
			result = this.age - that.age;
		}

		if(result == 0){
			result = this.email.compareTo(that.email);
		}

		return result;
	}

	@Override
	public String toString() {
		return "Person [" + firstName + " " + lastName + ", " + age + " years, email=" + email + "]\n";
	}

	/* Don't change the signature of this method. */
	public static Person valueOf(final String firstName, final String lastName, final int age, final String email){
		return new Person(firstName, lastName, age, email);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}
}
