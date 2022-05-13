package com.springboot.rest.example.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.rest.example.model.Book;
import com.springboot.rest.example.model.IssueBook;
import com.springboot.rest.example.model.Student;

@Repository
public interface BookIssueRepository extends CrudRepository<IssueBook, Integer> {

    public Page<IssueBook> findAll(Pageable pageable);
}