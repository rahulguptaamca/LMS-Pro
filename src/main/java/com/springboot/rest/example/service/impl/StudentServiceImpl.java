package com.springboot.rest.example.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.springboot.rest.example.dto.StudentDto;
import com.springboot.rest.example.dto.StudentExistingDto;
import com.springboot.rest.example.dto.StudentNewDto;
import com.springboot.rest.example.exception.ResourceNotFoundException;
import com.springboot.rest.example.model.Student;
import com.springboot.rest.example.repository.StudentRepository;
import com.springboot.rest.example.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student addStudent(Student student) {
        student = studentRepository.save(student);
        return student;

    }

    @Override
    public Student updateStudent(Student student) {
        Optional<Student> studentOpt = studentRepository.findById(student.getId());
        if (!studentOpt.isPresent()) {
            throw new ResourceNotFoundException("student not found");
        }
        Student student1 = studentOpt.get();
        student1.setFirstName(student.getFirstName());
        student1.setLastName(student.getLastName());
        student1.setEmail(student.getEmail());
        student1.setContactNumber(student.getContactNumber());
        student1.setCourseName(student.getCourseName());

        student1 = studentRepository.save(student1);
        return student1;
    }

    @Override
    public void deleteStudent(Integer studentId) {
        if (studentId == null) {
            throw new IllegalArgumentException("studentId must not be null");
        }
        Optional<Student> studentOpt = studentRepository.findById(studentId);
        if (!studentOpt.isPresent()) {
            throw new ResourceNotFoundException("student not found");
        }
        studentRepository.deleteById(studentId);
    }

    @Override
    public Student getStudentById(Integer studentId) {
        if (studentId == null) {
            throw new IllegalArgumentException("studentId must not be null");
        }

        Optional<Student> studentOpt = studentRepository.findById(studentId);
        if (!studentOpt.isPresent()) {
            throw new ResourceNotFoundException("student not found");
        }
        Student student = studentOpt.get();

       
        return student;
    }

    @Override
    public Page<Student> getAllStudents(Pageable pageable) {
        Page<Student> studentsPage = studentRepository.findAll(pageable);

        List<Student> students = new ArrayList<>();
        Page<Student> studentsDtoPage = new PageImpl<>(students, pageable, 0);

        if (studentsPage != null && !studentsPage.isEmpty()) {

            studentsPage.getContent().forEach(student -> {
                

                students.add(student);
            });
            studentsDtoPage =
                    new PageImpl<>(students, pageable, studentsPage.getTotalElements());
        }
        return studentsDtoPage;
    }
    
    @Override
    public List<Student> getAllStudents() {
    	List<Student> studentsList = (List<Student>) studentRepository.findAll();

       
        return studentsList;
    }

}