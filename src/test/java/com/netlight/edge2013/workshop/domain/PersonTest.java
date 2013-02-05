package com.netlight.edge2013.workshop.domain;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class PersonTest {
	@Test
	public void testCompare(){
		Person p1 = Person.valueOf("a", "a", 0, "a");
		Person p2 = Person.valueOf("a", "a", 0, "b");
		Person p3 = Person.valueOf("a", "a", 1, "b");
		Person p4 = Person.valueOf("a", "b", 1, "b");
		Person p5 = Person.valueOf("b", "b", 1, "b");
		
		List<Person> persons = Arrays.asList(p5, p4, p3, p2, p1);
		Collections.sort(persons);
		
		assertEquals("Correct sort order", Arrays.asList(p1, p2, p3, p4, p5), persons);
		assertTrue("Comparing same object yield 0", p1.compareTo(p1) == 0);
	}
}
