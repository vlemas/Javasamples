package com.vlm.samples;

import java.util.*;
import static java.util.stream.Collectors.toMap;

public class MapPhoneBook {

	public static void main(String[] args) {

		List<Person> people = Arrays.asList(
				new Person("David", "Archer", "Brookfield"),
				new Person("Elizabeth", "Pargetter", "Lower Loxley"),
				new Person("Lillian", "Bellamy", "The Dower House"),
				new Person("Lilly", "Pargetter", "Lower Loxley"),
				new Person("Lilly", "Pargetter", "Manchester"));
		
		Map<String, String> phoneBook
		   = people.stream().collect(toMap(Person::getName, Person::getAddress, (s, a) -> s + ", " + a));
		System.out.println("Name \t\t Addresses");
		phoneBook.forEach((k, s) -> System.out.println(k + "\t " + s));
		System.out.println("The Phonebook" + phoneBook);
	}

}
