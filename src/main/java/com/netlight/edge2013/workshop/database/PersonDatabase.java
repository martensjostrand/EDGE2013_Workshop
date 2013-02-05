package com.netlight.edge2013.workshop.database;

import java.util.List;

import com.netlight.edge2013.workshop.domain.Person;

public interface PersonDatabase {
	List<Person> getAllPersons();
	Person getPerson(String email);
	void addPerson(Person person);
}
