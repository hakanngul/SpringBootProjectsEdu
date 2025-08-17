package com.hakangul.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hakangul.controller.IStudentController;
import com.hakangul.dto.DtoStudent;
import com.hakangul.dto.DtoStudentIU;
import com.hakangul.service.IStudentService;



@RestController
@RequestMapping("/rest/api/student")
public class StudentControllerImpl implements IStudentController {

   
    @Autowired
    private IStudentService studentService;
    
    //Normalde DTO lar kullanılır direkt Student objesi kullanılmaz.
    @PostMapping(path= "/save")
    @Override
    public DtoStudent saveStudent(@RequestBody DtoStudentIU dtoStudentIU) {
        return studentService.saveStudent(dtoStudentIU);
    }

    @GetMapping(path= "/list")
    @Override
    public List<DtoStudent> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping(path= "/list/{id}")
    @Override
    public DtoStudent getStudentById(@PathVariable(name="id") Long id) {
        return studentService.getStudentById(id);
    }
    
    @DeleteMapping(path= "/delete/{id}")
    @Override
    public void deleteStudentById(@PathVariable(name="id") Long id) {
        studentService.deleteStudentById(id);
    }

    @PutMapping(path= "/update/{id}")
    @Override
    public DtoStudent updateStudent(@PathVariable(name="id") Long id, @RequestBody DtoStudentIU updaStudent) {
        return studentService.updateStudent(id, updaStudent);
    }
}