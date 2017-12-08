package kz.salta.ssdb.service;

import java.util.List;

import kz.salta.ssdb.model.Book;
import kz.salta.ssdb.model.Logbook;

public interface BookService {
	
	Book findOne(Long id);
	
	List<Book> findAll();
	
	void takeBook(Long id);
	
	void returnBook(Long id);
	
	List<Book> booksToReturnForCurrentUser();
}
