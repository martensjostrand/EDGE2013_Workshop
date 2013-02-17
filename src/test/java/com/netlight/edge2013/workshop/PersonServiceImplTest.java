package com.netlight.edge2013.workshop;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.netlight.edge2013.workshop.database.PersonDatabase;
import com.netlight.edge2013.workshop.domain.Person;
import com.netlight.edge2013.workshop.testutil.TestPersons;

public class PersonServiceImplTest {
	private final PersonDatabase personDatabase = mock(PersonDatabase.class);
	private final PersonService personService = new PersonServiceImpl(personDatabase);
	private final List<Person> expectedPersons = TestPersons.BY_NAME;

	@Before
	public void setUp(){
		when(personDatabase.getAllPersonsByName()).thenReturn(expectedPersons);
		when(personDatabase.getAllPersonsByAge(true)).thenReturn(expectedPersons);
		when(personDatabase.getPerson(eq(TestPersons.STATLER_EMAIL))).thenReturn(TestPersons.STATLER);
	}

	@Test
	public void getPersonsByName(){
		List<Person> actualPersons = personService.getAllPersonsByName();
		assertEquals("Same persons", expectedPersons, actualPersons);
	}

	@Test
	public void getPersonsByAge(){
		List<Person> actualPersons = personService.getAllPersonsByAge(true);
		assertEquals("Same persons", expectedPersons, actualPersons);
		verify(personDatabase).getAllPersonsByAge(true);
	}

	@Test
	public void getPerson(){
		Person actual = personService.getPerson(TestPersons.STATLER_EMAIL);
		assertEquals("Should be statler", TestPersons.STATLER, actual);
	}

	@Test
	public void printStats(){
		String stats = personService.printStats();
		assertEquals("Start of stats\n- Really old person\n- Really old person\nEnd of stats\n", stats);
	}
}
