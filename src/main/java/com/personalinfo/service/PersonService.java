package com.personalinfo.service;

import java.util.List;
import com.personalinfo.model.Person;

public interface PersonService {

	// Completed
	public List<Person> getPersons();

	public Person getPersonById(long id);

	//Completed
	public Person addPerson(Person details);

	public Person updatePerson(Person person,long id);

	//Completed
	public void deleteById(int id);

}
