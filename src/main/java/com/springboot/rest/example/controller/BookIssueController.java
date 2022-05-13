package com.springboot.rest.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.rest.example.model.Book;
import com.springboot.rest.example.model.IssueBook;
import com.springboot.rest.example.model.Student;
import com.springboot.rest.example.service.BookIssueService;
import com.springboot.rest.example.service.BookService;
import com.springboot.rest.example.service.StudentService;

@RestController
@RequestMapping(path = "/booksissue")
public class BookIssueController {

	@Autowired
    private BookIssueService bookIssueService;
	
	@Autowired
    private BookService bookService;
	@Autowired
    private StudentService studentService;
	
	 @PostMapping(path = "/issue")
	    public ResponseEntity<Book> issueBook(@RequestBody IssueBook issueBook) {
		 Book book=bookService.getBookById(issueBook.getBid());
		 Student student=studentService.getStudentById(issueBook.getSid());
		 bookIssueService.checkBookAlreadyIssued(book);
		 IssueBook bookIssue=bookIssueService.issueBook(issueBook);
		 book=bookService.updateBookWithIssueStatus(book);
	        return ResponseEntity.ok(book);
	    }
}
