package com.netlight.edge2013.workshop.database;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.netlight.edge2013.workshop.domain.Person;

public class PersonDatabaseImpl implements PersonDatabase {
	private final Map<String, Person> persons = new HashMap<String, Person>();

	@Override
	public List<Person> getAllPersonsByName() {
		List<Person> all = new ArrayList<Person>(persons.values());
		Collections.sort(all);
		return all;
	}

	@Override
	public List<Person> getAllPersonsByAge(final boolean youngestFirst) {
		final List<Person> all = getAllPersons();
		final Comparator<Person> ageComparator = new Comparator<Person>() {
			@Override
			public int compare(Person p1, Person p2) {
				if (youngestFirst){
					return p1.getAge() - p2.getAge();
				} else {
					return p2.getAge() - p1.getAge();
				}
			}
		};

		Collections.sort(all, ageComparator);
		return all;
	}

	private List<Person> getAllPersons(){
		List<Person> all = new ArrayList<Person>(persons.values());
		Collections.sort(all);
		return all;
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
