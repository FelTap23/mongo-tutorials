package com.feltap.samples.mongotutorials.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.feltap.samples.mongotutorials.model.Person;

@Repository
public interface PersonRepository  extends MongoRepository<Person, String>{

	
	//Projection sample using MongoRepository
	@Query(value = "{}", fields = "{name: 1, gender: 1, _id: 0}")
	List<Person> findOnlyName();
}
