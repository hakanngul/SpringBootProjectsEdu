package com.hakangul.service;

import java.util.List;

import com.hakangul.entities.Student;

public interface IStudentService {

    public Student saveStudent(Student student);

    public List<Student> getAllStudents();
    
    public Student getStudentById(Long id);

    public void deleteStudentById(Long id);

    public Student updateStudent(Long id, Student updaStudent);

}
