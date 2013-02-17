package com.netlight.edge2013.workshop.testutil;

import java.util.Arrays;
import java.util.List;

import com.netlight.edge2013.workshop.domain.Person;

public class TestPersons {
	public static final String WALDORF_EMAIL = "theincrediblehunk@match.com";
	public static final String STATLER_EMAIL = "statler@muppets.com";
	public static  final Person STATLER = Person.valueOf("Statler", "Muppet", 91, STATLER_EMAIL);
	public static final Person WALDORF = Person.valueOf("Waldorf", "Muppet", 87, WALDORF_EMAIL);
	public static final List<Person> BY_NAME = Arrays.asList(STATLER, WALDORF);
}
