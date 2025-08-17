package com.hakangul.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hakangul.dto.DtoStudent;
import com.hakangul.dto.DtoStudentIU;
import com.hakangul.entities.Student;
import com.hakangul.repository.IStudentRepository;
import com.hakangul.service.IStudentService;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private IStudentRepository studentRepository;

    @Override
    public DtoStudent saveStudent(DtoStudentIU dtoStudentIU) {
        Student student = new Student();
        DtoStudent response = new DtoStudent();
        BeanUtils.copyProperties(dtoStudentIU, student);
        Student dbStudent = studentRepository.save(student);

        BeanUtils.copyProperties(dbStudent, response);
        return response;
    }

    @Override
    public List<DtoStudent> getAllStudents() {
        List<DtoStudent> dtoList = new ArrayList<>();
        List<Student> students = studentRepository.findAllStudents();
        for(Student student : students) {
            DtoStudent dtoStudent = new DtoStudent();
            BeanUtils.copyProperties(student, dtoStudent);
            dtoList.add(dtoStudent);
        }
        return dtoList;
    }

    @Override
    public DtoStudent getStudentById(Long id) {
        Optional<Student> optional = studentRepository.findById(id);
        if (optional.isPresent()) {
            DtoStudent dtoStudent = new DtoStudent();
            BeanUtils.copyProperties(optional.get(), dtoStudent);
            return dtoStudent;
        } else {
            return null;
        }
    }

    @Override
    public void deleteStudentById(Long id) {
        Student findStudent = getStudent(id);
        if (findStudent != null) {
            studentRepository.delete(findStudent);
        } else {
            System.out.println("Student not found");
            throw new RuntimeException("Student not found");
        }
    }

    @Override
    public DtoStudent updateStudent(Long id, DtoStudentIU updaStudent) {
        Student dbStudent = getStudent(id);
        DtoStudent dto = new DtoStudent();
        if (dbStudent != null) {
            dbStudent.setFirstName(updaStudent.getFirstName());
            dbStudent.setLastName(updaStudent.getLastName());
            dbStudent.setBirthOfDate(updaStudent.getBirthOfDate());
            
            Student updatedStudent = studentRepository.save(dbStudent);
            BeanUtils.copyProperties(updatedStudent, dto);
            return dto;

        } else {
            return null;
        }

    }

    private Student getStudent(Long id) {
        Optional<Student> optional = studentRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            return null;
        }
    }

}
