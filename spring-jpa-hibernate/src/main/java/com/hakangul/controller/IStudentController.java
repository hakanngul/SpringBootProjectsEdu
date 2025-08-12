package com.hakangul.controller;

import java.util.List;

import com.hakangul.entities.Student;



public interface IStudentController {

    public  Student savStudent(Student student);

    public List<Student> getAllStudents();

    public  Student getStudentById(Long id);

    public  void deleteStudentById(Long id);

    public Student updateStudent(Long id, Student updaStudent);


}
