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
import com.hakangul.entities.Student;
import com.hakangul.service.IStudentService;



@RestController
@RequestMapping("/rest/api/student")
public class StudentControllerImpl implements IStudentController {

   
    @Autowired
    private IStudentService studentService;
    
    //Normalde DTO lar kullanılır direkt Student objesi kullanılmaz.
    @PostMapping(path= "/save")
    @Override
    public Student savStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @GetMapping(path= "/list")
    @Override
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping(path= "/list/{id}")
    @Override
    public Student getStudentById(@PathVariable(name="id") Long id) {
        return studentService.getStudentById(id);
    }
    
    @DeleteMapping(path= "/delete/{id}")
    @Override
    public void deleteStudentById(@PathVariable(name="id") Long id) {
        studentService.deleteStudentById(id);
    }

    @PutMapping(path= "/update/{id}")
    @Override
    public Student updateStudent(@PathVariable(name="id") Long id, @RequestBody Student updaStudent) {
        return studentService.updateStudent(id, updaStudent);
    }
}