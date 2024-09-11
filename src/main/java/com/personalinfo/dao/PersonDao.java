package com.personalinfo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.personalinfo.model.Person;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;

@Repository
public class PersonDao {

	@Autowired
	private JdbcTemplate temp;

	private static final RowMapper<Person> PERSON_ROW_MAPPER = (rs, rowNum) -> new Person(
		    rs.getInt("id"),
		    rs.getString("name"),
		    rs.getString("company"),
		    rs.getInt("salary")
		);

	public PersonDao(JdbcTemplate jdbcTemplate) {
		this.temp = jdbcTemplate;
	}

	public List<Person> findAll() {
		String sql = "SELECT * FROM person";
		return temp.query(sql, (rs, rowNum) -> new Person(rs.getInt("id"), rs.getString("name"),
				rs.getString("company"), rs.getInt("salary")));
	}

	public Person save(Person person) {
		System.out.println(person);
		String sql = "INSERT INTO person (name, company, salary) VALUES (?, ?, ?)";
		temp.update(sql, person.getName(), person.getCompany(), person.getSalary());
		return person;
	}

	public void deleteById(int id) {
		String sql = "DELETE FROM person WHERE id = ?";
		temp.update(sql, id);
	}
	
	public Person getPersonById(long id) {
	    String sql = "SELECT * FROM person WHERE id = ?";
	    return temp.queryForObject(sql, PERSON_ROW_MAPPER, id);
	}
	
	public Person updatePerson(Person person,long id) {

		String sql = "UPDATE person SET name = ?, company = ?, salary = ? WHERE id = ?";
	    temp.update(sql, person.getName(), person.getCompany(), person.getSalary(), id);
	
		return person;
	}

}