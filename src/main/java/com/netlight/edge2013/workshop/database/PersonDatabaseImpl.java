package com.netlight.edge2013.workshop.database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.netlight.edge2013.workshop.domain.Person;

public class PersonDatabaseImpl implements PersonDatabase {

	private final Map<String, Person> persons = new HashMap<String, Person>();
	
	@Override
	public List<Person> getAllPersons() {
		return new ArrayList<Person>(persons.values());
	}

	@Override
	public Person getPerson(final String email) {
		return persons.get(email);
	}

	@Override
	public void addPerson(Person person) {
		persons.put(person.getEmail(), person);
	}

	
}
