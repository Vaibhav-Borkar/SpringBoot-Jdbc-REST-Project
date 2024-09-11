package com.personalinfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.personalinfo.model.Person;
import com.personalinfo.service.PersonService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
public class MyController {
   
	@Autowired
	PersonService personService;
	
	@GetMapping("/get")
	public List<Person> getInfo() {
		return personService.getPersons();
	}
	@PostMapping("/add")
	public Person addPerson(@RequestBody Person person) {
		return personService.addPerson(person);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deletePerson(@PathVariable int id) {
		personService.deleteById(id);
	}
	
	@GetMapping("/get/{id}")
	public Person getPersonById(@PathVariable long id) {
		return personService.getPersonById(id);
	}
	
	@PutMapping("/update/{id}")
    public Person updatePerson(@RequestBody Person person ,@PathVariable long id) {
		return personService.updatePerson(person, id);
		
	}
}
