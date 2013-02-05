package com.netlight.edge2013.workshop.domain;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class PersonTest {
	private final Person p1 = Person.valueOf("a", "a", 0, "a");
	private final Person p2 = Person.valueOf("a", "a", 0, "b");
	private final Person p3 = Person.valueOf("a", "a", 1, "b");
	private final Person p4 = Person.valueOf("a", "b", 1, "b");
	private final Person p5 = Person.valueOf("b", "b", 1, "b");
	private final Person equalToP1 = Person.valueOf("a", "a", 0, "a");
	
	@Test
	public void testCompare(){
		List<Person> persons = Arrays.asList(p5, p4, p3, p2, p1);
		Collections.sort(persons);
		
		assertEquals("Correct sort order", Arrays.asList(p1, p2, p3, p4, p5), persons);
		assertTrue("Comparing same object yield 0", p1.compareTo(p1) == 0);
	}
	
	@Test
	public void equalsAndhashCode(){
		assertTrue("Should be equals", p1.equals(equalToP1));
		assertEquals("Should have same hashCode", p1.hashCode(), equalToP1.hashCode());
		assertFalse("Should not ne equal", p1.equals(p2));
		assertNotEquals("Not same hashCode", p1.hashCode(), p2.hashCode());
	}
}
