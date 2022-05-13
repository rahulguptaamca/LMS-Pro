package com.springboot.rest.example.service;

import com.springboot.rest.example.model.Book;
import com.springboot.rest.example.model.IssueBook;
import com.springboot.rest.example.model.Student;

public interface BookIssueService {

	IssueBook issueBook(IssueBook issueBook);
	void checkBookAlreadyIssued(Book book);
}
