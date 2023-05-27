package com.devendra.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.devendra.crud.model.Student;
import com.devendra.crud.repository.StudentRepository;

@CrossOrigin
@RestController
public class UserController {

    @Autowired
    StudentRepository studentRepository;

     /**
     * Create new student
     *
     * param employee
     * return ResponseEntity
     */
    @PostMapping("/student")
    public ResponseEntity<Student> newEmployee(@RequestBody Student student) {
        Student s = studentRepository
                    .save(Student.builder()
                        .name(student.getName())
                        .build());
        return new ResponseEntity<>(s, HttpStatus.OK);
    }

    /**
     * Get all the student
     *
     * return ResponseEntity
     */
    @GetMapping("/students")
    public ResponseEntity<List<Student>> getEmployees() {
        try {
            return new ResponseEntity<>(studentRepository.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
