package com.feltap.samples.mongotutorials;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.WriteConcernResolver;

import com.feltap.samples.mongotutorials.model.Book;
import com.feltap.samples.mongotutorials.model.Person;
import com.feltap.samples.mongotutorials.repositories.BookRepository;

@SpringBootApplication
public class MongoTutorialsApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MongoTutorialsApplication.class, args);
	}

	@Autowired
	private MongoTemplate template;

	@Autowired
	private WriteConcernResolver writeConcernResolver;

	@Autowired
	private BookRepository bookRepository;

	@Override
	public void run(String... args) throws Exception {

		// Testing of Write concern
		template.setWriteConcernResolver(writeConcernResolver);
		Person person = new Person("Luis", "Tapia", LocalDate.of(1993, 12, 23));
		person = template.save(person, "Person");

		/*Book user = bookRepository
				.save(new Book("xx", "el lenguaje de programacion z", "pedrito sola", LocalDate.of(1998, 12, 1), 500));
		System.out.println(user);
		*/
		
		Optional<Book> optionalBook=  bookRepository.findById("xx");
		if(optionalBook.isPresent()) {
			System.out.println(optionalBook.get());
		}else {
			System.out.println("I did not found the book");
		}
		
		List<Book> booksByEditorial = bookRepository.findByPriceBetween(0, 499);
		System.out.println(booksByEditorial);
	}

}
