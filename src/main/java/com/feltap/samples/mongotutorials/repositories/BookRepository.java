package com.feltap.samples.mongotutorials.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.feltap.samples.mongotutorials.model.Book;

@Repository
public interface BookRepository  extends MongoRepository<Book, String>{
	
	public List<Book> findByEditorial(String editorial); //{"editorial": editorial}}
	public List<Book> findByPriceBetween(double from, double to);//{"price":  {$gt: from ,$lt:to}}
	public List<Book> findByPriceGreaterThan(double price);//{"price": {$gt: price}}
	public List<Book> findByPriceLessThan(double price);//{"price": {$lt: price}}
	public List<Book> findByTitle(String title);//{"title": titulo}
	public List<Book> findByTitleNotNull();//{"title": {$ne : null}}
	public List<Book> findByTitleNull();//{"title": null}
	public List<Book> findByTitleLike(String title); //{"title": titulo} titulo  as regex
	public List<Book> findByTitleRegex(String regex); //{"title": {$regex: regex}}
	public List<Book> findByTitleNot(String title); //{"title":{$ne: title}}
}
