package com.springboot.rest.example.service;

import java.util.List;

import com.springboot.rest.example.model.Book;
import com.springboot.rest.example.model.Student;

public interface BookService {

	Book add(Book b);
	
	Book getBookById(Integer bookId);
	
	Book updateBookWithIssueStatus(Book book);
	
	List<Book> getAllIssuedBooks();
}
