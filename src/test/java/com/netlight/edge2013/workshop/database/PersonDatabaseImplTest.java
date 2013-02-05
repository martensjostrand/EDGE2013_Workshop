package com.netlight.edge2013.workshop.database;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.netlight.edge2013.workshop.domain.Person;
import com.netlight.edge2013.workshop.testutil.TestPersons;

public class PersonDatabaseImplTest {
	
	private final PersonDatabase personDatabase = new PersonDatabaseImpl();
	
	@Before
	public void setUp(){
		personDatabase.addPerson(TestPersons.STATLER);
		personDatabase.addPerson(TestPersons.WALDORF);
	}
	
	@Test
	public void databaseRoundtrip(){
		final List<Person> actualPersons = personDatabase.getAllPersonsByName();
		assertEquals("All persons should be listed", TestPersons.BY_NAME, actualPersons);

		final Person expected = personDatabase.getPerson(TestPersons.WALDORF_EMAIL);
		assertEquals("Should be waldorf", TestPersons.WALDORF, expected);
	}
	
	@Test
	public void testGetByName(){
		final List<Person> expected = Arrays.asList(TestPersons.STATLER, TestPersons.WALDORF);
		assertEquals("Statler then Waldorf", expected, personDatabase.getAllPersonsByName());
	}
	
	@Test
	public void youngestFirst(){
		final List<Person> youngestFirst = Arrays.asList( TestPersons.WALDORF, TestPersons.STATLER);
		assertEquals("Waldorf then Statler", youngestFirst, personDatabase.getAllPersonsByAge(true));
	}
	
	@Test
	public void oldestFirst(){
		final List<Person> oldestFirst = Arrays.asList(TestPersons.STATLER, TestPersons.WALDORF);
		assertEquals("Statler then Waldorf", oldestFirst, personDatabase.getAllPersonsByAge(false));
	}
	
	
	
}
