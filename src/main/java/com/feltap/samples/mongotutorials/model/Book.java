package com.feltap.samples.mongotutorials.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "#{@applicationConfiguration.getCollectionName()}")
public class Book {

	@Id
	private String isbn;
	private String title;
	private String editorial;
	private LocalDate publicationDate;
	private double price;

	public Book() {

	}

	public Book(String isbn, String title, String editorial, LocalDate publicationDate, double price) {
		this.isbn = isbn;
		this.title = title;
		this.editorial = editorial;
		this.publicationDate = publicationDate;
		this.price = price;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public LocalDate getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(LocalDate publicationDate) {
		this.publicationDate = publicationDate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + ", editorial=" + editorial + ", publicationDate="
				+ publicationDate + ", price=" + price + "]";
	}
}
