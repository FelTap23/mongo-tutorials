package com.feltap.samples.mongotutorials.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.feltap.samples.mongotutorials.model.Person;


@Repository
public interface PersonRepository  extends MongoRepository<Person, String>{

}
