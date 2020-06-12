package com.feltap.samples.mongotutorials.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.feltap.samples.mongotutorials.model.GenderCount;
import com.feltap.samples.mongotutorials.model.Person;
import com.feltap.samples.mongotutorials.repositories.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	
	@Autowired
	private PersonRepository repository;
	
	
	//Sample of project operation using Mongo Template
	public List<Person> findAllOnlyBirthDate(){
		Query query =  new Query();
		query.fields().include("birthDate").exclude("_id");
		return  mongoTemplate.find(query, Person.class);
	}
	
	public List<GenderCount> countByGender(){
		GroupOperation groupOperation = Aggregation.group("gender").count().as("total");
		Aggregation aggregation = Aggregation.newAggregation(groupOperation);
		AggregationResults<GenderCount> result = mongoTemplate.aggregate(aggregation,Person.class, GenderCount.class);
		return result.getMappedResults();
	}
	
	
	public List<Person> findAll() {
		return repository.findAll();
	}
	
	public List<Person> findAllOnlyName(){
		return repository.findOnlyName();
	}
	
	public Person save(Person person) {
		return repository.save(person);
	}
	

}
