package com.netlight.edge2013.workshop;

import java.util.List;

import com.netlight.edge2013.workshop.domain.Person;

public interface PersonService {
	List<Person> getAllPersons();
	Person getPerson(String email);
	void addPerson(Person person);
}
