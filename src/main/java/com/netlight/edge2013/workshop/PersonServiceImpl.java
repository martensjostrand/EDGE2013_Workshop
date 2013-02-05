package com.netlight.edge2013.workshop;

import java.util.List;

import com.netlight.edge2013.workshop.database.PersonDatabase;
import com.netlight.edge2013.workshop.domain.Person;

public class PersonServiceImpl implements PersonService{

	private final PersonDatabase personDatabase;

	public PersonServiceImpl(final PersonDatabase personDatabase) {
		this.personDatabase = personDatabase;
	}

	@Override
	public List<Person> getAllPersonsByName() {
		return personDatabase.getAllPersonsByName();
	}

	@Override
	public List<Person> getAllPersonsByAge(boolean youngestFirst) {
		return personDatabase.getAllPersonsByAge(youngestFirst);
	}
	
	@Override
	public Person getPerson(String email) {
		return personDatabase.getPerson(email);
	}

	@Override
	public void addPerson(Person person) {
		personDatabase.addPerson(person);
	}

}
