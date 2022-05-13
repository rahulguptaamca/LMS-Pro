package com.springboot.rest.example.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.springboot.rest.example.dto.StudentDto;
import com.springboot.rest.example.dto.StudentExistingDto;
import com.springboot.rest.example.dto.StudentNewDto;
import com.springboot.rest.example.model.Student;

public interface StudentService {

    Student addStudent(Student student);

    Student updateStudent(Student student);

    void deleteStudent(Integer studentId);

    Student getStudentById(Integer studentId);

    Page<Student> getAllStudents(Pageable pageable);
    
    List<Student> getAllStudents();
}