package com.netlight.edge2013.workshop.database;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.netlight.edge2013.workshop.database.PersonDatabase;
import com.netlight.edge2013.workshop.database.PersonDatabaseImpl;
import com.netlight.edge2013.workshop.domain.Person;
import com.netlight.edge2013.workshop.testutil.TestPersons;

public class PersonDatabaseImplTest {
	
	private final PersonDatabase personDatabase = new PersonDatabaseImpl();
	
	@Test
	public void databaseRoundtrip(){
		personDatabase.addPerson(TestPersons.STATLER);
		personDatabase.addPerson(TestPersons.WALDORF);

		List<Person> actualPersons = personDatabase.getAllPersons();
		assertEquals("All persons should be listed", TestPersons.ALL, actualPersons);

		Person expected = personDatabase.getPerson(TestPersons.WALDORF_EMAIL);
		assertEquals("Should be waldorf", TestPersons.WALDORF, expected);
	}
}
