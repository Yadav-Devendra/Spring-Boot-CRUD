package com.devendra.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.devendra.crud.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{
    
}
