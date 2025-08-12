package com.hakangul.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hakangul.entities.Student;

@Repository
public interface IStudentRepository extends  JpaRepository<Student, Long> {

}
