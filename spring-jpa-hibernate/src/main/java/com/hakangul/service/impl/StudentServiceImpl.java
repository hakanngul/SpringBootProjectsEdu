package com.hakangul.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hakangul.dto.DtoCourse;
import com.hakangul.dto.DtoStudent;
import com.hakangul.dto.IU.DtoStudentIU;
import com.hakangul.entities.Student;
import com.hakangul.repository.StudentRepository;
import com.hakangul.service.IStudentService;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private StudentRepository studentRepository;

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
        DtoStudent dtoStudent = new DtoStudent();
        Optional<Student> optional = studentRepository.findById(id);
        
        if(optional.isEmpty()) {
            return null;
        }

        Student dbStudent = optional.get();
        BeanUtils.copyProperties(dbStudent, dtoStudent);
        if(dbStudent.getCourses() != null && !dbStudent.getCourses().isEmpty()) {
            dbStudent.getCourses().forEach(course -> {
                DtoCourse dtoCourse = new DtoCourse();
                BeanUtils.copyProperties(course, dtoCourse);
                dtoStudent.getCourses().add(dtoCourse);
            });
        }

        return dtoStudent;
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
    public DtoStudent updateStudent(Long id, DtoStudentIU updateStudent) {
        Student dbStudent = getStudent(id);
        DtoStudent dto = new DtoStudent();
        if (dbStudent != null) {
            dbStudent.setFirstName(updateStudent.getFirstName());
            dbStudent.setLastName(updateStudent.getLastName());
            dbStudent.setBirthOfDate(updateStudent.getBirthOfDate());
            
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
