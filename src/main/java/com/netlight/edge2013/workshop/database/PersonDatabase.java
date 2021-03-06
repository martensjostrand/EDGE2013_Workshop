package com.netlight.edge2013.workshop.database;

import java.util.List;

import com.netlight.edge2013.workshop.domain.Person;

public interface PersonDatabase {
	List<Person> getAllPersonsByAge(boolean youngestFirst);
	List<Person> getAllPersonsByName();
	Person getPerson(String email);
	void addPerson(Person person);
}
