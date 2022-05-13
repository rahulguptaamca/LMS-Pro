package com.springboot.rest.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.rest.example.model.Book;
import com.springboot.rest.example.model.Student;
import com.springboot.rest.example.service.BookService;
import com.springboot.rest.example.service.StudentService;

@RestController
@RequestMapping(path = "/books")
public class BookController {

	@Autowired
    private BookService bookService;
	
	 @PostMapping(path = "/add")
	    public ResponseEntity<Book> addStudent(@RequestBody Book book) {
		 Book book1 = bookService.add(book);
	        return ResponseEntity.ok(book1);
	    }
	 
	 @GetMapping(path = "/allBooks")
	    public ResponseEntity<List<Book>> getStudents() {
	        List<Book> issuedBooksLst = bookService.getAllIssuedBooks();
	        return ResponseEntity.ok(issuedBooksLst);
	    }
}
