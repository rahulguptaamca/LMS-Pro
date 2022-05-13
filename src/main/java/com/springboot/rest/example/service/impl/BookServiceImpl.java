package com.springboot.rest.example.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.springboot.rest.example.dto.StudentDto;
import com.springboot.rest.example.dto.StudentExistingDto;
import com.springboot.rest.example.dto.StudentNewDto;
import com.springboot.rest.example.exception.ResourceNotFoundException;
import com.springboot.rest.example.model.Book;
import com.springboot.rest.example.model.Student;
import com.springboot.rest.example.repository.BookRepository;
import com.springboot.rest.example.repository.StudentRepository;
import com.springboot.rest.example.service.BookService;
import com.springboot.rest.example.service.StudentService;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book add(Book book) {
    	book.setBookIssue("N");
    	book = bookRepository.save(book);
        return book;

    }

	@Override
	public Book updateBookWithIssueStatus(Book book) {
		book.setBookIssue("Y");
		book = bookRepository.save(book);
		return book;
	}

    /*@Override
    public void deleteStudent(Integer studentId) {
        if (studentId == null) {
            throw new IllegalArgumentException("studentId must not be null");
        }
        Optional<Student> studentOpt = studentRepository.findById(studentId);
        if (!studentOpt.isPresent()) {
            throw new ResourceNotFoundException("student not found");
        }
        studentRepository.deleteById(studentId);
    }*/

    @Override
    public Book getBookById(Integer bookId) {
        if (bookId == null) {
            throw new IllegalArgumentException("bookId must not be null");
        }

        Optional<Book> bookOpt = bookRepository.findById(bookId);
        if (!bookOpt.isPresent()) {
            throw new ResourceNotFoundException("book not found");
        }
        Book book = bookOpt.get();

       
        return book;
    }

    @Override
    public List<Book> getAllIssuedBooks() {
    	List<Book> issudedBookList = (List<Book>) bookRepository.findAll();
    	issudedBookList=processIssuedBooksList(issudedBookList);
       
        return issudedBookList;
    }
    
    List<Book> processIssuedBooksList(List<Book> issudedBookList){
    	List<Book> issudedBookList1=new ArrayList<Book>();
    	if(issudedBookList !=null && !issudedBookList.isEmpty()){
    		issudedBookList1=issudedBookList.stream().filter(b->b.getBookIssue().equals("Y")).collect(Collectors.toList());
    	}
    	
    	return issudedBookList1;
    }

}