package com.hakangul.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hakangul.entities.Student;
import com.hakangul.repository.IStudentRepository;
import com.hakangul.service.IStudentService;


@Service
public class StudentServiceImpl implements IStudentService {



    @Autowired
    private IStudentRepository studentRepository;

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        Optional<Student> optional = studentRepository.findById(id);
        if(optional.isPresent()) {
            return optional.get();
        } else {
            return null;
        }
    }

    @Override
    public void deleteStudentById(Long id) {
        Student findStudent = getStudentById(id);
        if(findStudent != null) {
            studentRepository.delete(findStudent);
        } else {
            System.out.println("Student not found");
            throw new RuntimeException("Student not found");
        }
    }

    @Override
    public Student updateStudent(Long id, Student updaStudent) {
        Student dbStudent = getStudentById(id);
        if(dbStudent != null) {
            dbStudent.setFirstName(updaStudent.getFirstName());
            dbStudent.setLastName(updaStudent.getLastName());
            dbStudent.setBirthOfDate(updaStudent.getBirthOfDate());
            return studentRepository.save(dbStudent);
        } else {
            return null;
        }
        
    }

}
