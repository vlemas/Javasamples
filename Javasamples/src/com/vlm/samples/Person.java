package com.vlm.samples;

import java.util.ArrayList;
import java.util.List;

public class Person {
	private String firstName, lastName, address;
	private List<Person> dependents;
	
	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dependents = new ArrayList<Person>();
	}
	public Person(String firstName, String lastName, String address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dependents = new ArrayList<Person>();
		this.address = address;
	}
	
	public Person(String firstName, String lastName, List<Person> dependents) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dependents = dependents;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getName() {
		return firstName + " "+lastName;
	}
	public List<Person> getDependents(){
		return dependents;
	}
	public void addDependent(Person dependent) {
		this.dependents.add(dependent);
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
