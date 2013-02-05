package com.netlight.edge2013.workshop;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.netlight.edge2013.workshop.database.PersonDatabase;
import com.netlight.edge2013.workshop.domain.Person;
import com.netlight.edge2013.workshop.testutil.TestPersons;

public class PersonServiceImplTest {

	private final PersonDatabase personDatabase = mock(PersonDatabase.class);
	private final PersonService personService = new PersonServiceImpl(personDatabase); 
	
	@Before
	public void setUp(){
		when(personDatabase.getAllPersonsByName()).thenReturn(TestPersons.ALL);
		when(personDatabase.getPerson(eq(TestPersons.STATLER_EMAIL))).thenReturn(TestPersons.STATLER);
	}

	@Test
	public void getPersons(){
		List<Person> actualPersons = personService.getAllPersonsByName();
		assertEquals("Same persons", TestPersons.ALL, actualPersons);
	}

	@Test
	public void getPerson(){
		Person actual = personService.getPerson(TestPersons.STATLER_EMAIL);
		assertEquals("Should be statler", TestPersons.STATLER, actual);
	}

}
