package com.netlight.edge2013.workshop;

import java.util.List;

import com.netlight.edge2013.workshop.database.PersonDatabase;
import com.netlight.edge2013.workshop.domain.Person;

public class PersonServiceImpl implements PersonService {
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

	@Override
	public String printStats() {
		String stats = "Start of stats\n";
		List<Person> persons = personDatabase.getAllPersonsByName();
		for (Person person : persons) {
			if (person.getAge() > 150) {
				stats += "- Dead guy\n";
			} else if (person.getAge() > 50) {
				stats += "- Really old person\n";
			} else if (person.getAge() > 20) {
				stats += "- Old person\n";
			} else {
				stats += "- Youngster.\n";
			}
		}
		stats += "End of stats\n";
		return stats;
	}
}
