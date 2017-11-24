package com.aprendendojava.service;

import java.util.List;

import com.aprendendojava.model.Person;

public interface PersonService {

	public void addPerson(Person p);
	public void updatePerson(Person p);
	public List<Person> listPeople();
	public Person getPersonById(int id);
	public void removePerson(int id);
	
}
