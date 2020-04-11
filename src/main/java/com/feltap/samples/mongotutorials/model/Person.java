package com.feltap.samples.mongotutorials.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Person {
	
	@Id
	private String id;
	private String name;
	private String lastName;
	private LocalDate birthDate;
	
	public Person(String name, String lastName, LocalDate birthDate) {
		this.name = name;
		this.lastName = lastName;
		this.birthDate = birthDate;
	}

	public Person() {
	
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", lastName=" + lastName + ", birthDate=" + birthDate + "]";
	}
	
}
