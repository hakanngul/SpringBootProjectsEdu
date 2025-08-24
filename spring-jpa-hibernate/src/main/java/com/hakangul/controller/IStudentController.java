package com.hakangul.controller;

import java.util.List;

import com.hakangul.dto.DtoStudent;
import com.hakangul.dto.IU.DtoStudentIU;



public interface IStudentController {

    public  DtoStudent saveStudent(DtoStudentIU dtoStudentIU);

    public List<DtoStudent> getAllStudents();

    public  DtoStudent getStudentById(Long id);

    public  void deleteStudentById(Long id);

    public DtoStudent updateStudent(Long id, DtoStudentIU updaStudent);


}
