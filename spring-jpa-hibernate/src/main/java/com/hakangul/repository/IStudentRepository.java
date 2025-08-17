package com.hakangul.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hakangul.entities.Student;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Long> {

    @Query(value = "FROM Student", nativeQuery = false)
    List<Student> findAllStudents();

}
