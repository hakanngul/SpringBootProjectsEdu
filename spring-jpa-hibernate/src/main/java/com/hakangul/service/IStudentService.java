package com.hakangul.service;

import java.util.List;

import com.hakangul.dto.DtoStudent;
import com.hakangul.dto.DtoStudentIU;


public interface IStudentService {

    public DtoStudent saveStudent(DtoStudentIU student);

    public List<DtoStudent> getAllStudents();
    
    public DtoStudent getStudentById(Long id);

    public void deleteStudentById(Long id);

    public DtoStudent updateStudent(Long id, DtoStudentIU updaStudent);

}
