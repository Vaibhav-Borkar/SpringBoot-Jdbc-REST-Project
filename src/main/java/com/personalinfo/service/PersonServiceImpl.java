package com.personalinfo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.RowMapper;
import com.personalinfo.dao.PersonDao;
import com.personalinfo.model.Person;

@Service
public class PersonServiceImpl implements PersonService {
	
	// Define a RowMapper for the Person class
	private static final RowMapper<Person> PERSON_ROW_MAPPER = (rs, rowNum) -> new Person(
	    rs.getInt("id"),
	    rs.getString("name"),
	    rs.getString("company"),
	    rs.getInt("salary")
	);

	@Autowired
	PersonDao dao;
	
	@Override
	public List<Person> getPersons() {

		return dao.findAll();
	}

	@Override
	public Person getPersonById(long id) {
		return dao.getPersonById(id);
	}

	@Override
	public Person addPerson(Person person) {

	    return dao.save(person);
	
	}

	@Override
	public Person updatePerson(Person person,long id) {

		return dao.updatePerson(person, id);
		
	}

	@Override
	public void deleteById(int id) {
         dao.deleteById(id);
	}

}
