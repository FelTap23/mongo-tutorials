package com.feltap.samples.mongotutorials.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.feltap.samples.mongotutorials.model.GenderCount;
import com.feltap.samples.mongotutorials.model.Person;
import com.feltap.samples.mongotutorials.service.PersonService;

@RestController
public class PersonController {
	
	

	@Autowired 
	private PersonService service;
	
	
	@GetMapping("/person")
	public List<Person> findAllPersons(){
		return  service.findAll();
	}
	
	
	@PostMapping("/person")
	public ResponseEntity<Person> createPersons(@RequestBody Person person){
		Person aux =  service.save(person);
		if(aux.getId() != null) {
			return new ResponseEntity<>(aux , HttpStatus.CREATED);
		}else{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping("/gender-count")
	public List<GenderCount> findGenderCount(){
		return service.countByGender();
	} 
	
	@GetMapping("/person-name")
	public List<Person> findAllOnlyNamePersons(){
		return  service.findAllOnlyName();
	}
	
	@GetMapping("/person-birth-date")
	public List<Person> findAllOnlyBirthDate(){
		return service.findAllOnlyBirthDate();
	}
	
}
