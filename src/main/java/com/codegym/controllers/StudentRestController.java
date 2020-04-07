package com.codegym.controllers;

import com.codegym.models.Student;
import com.codegym.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class StudentRestController {

    @Autowired
    IStudentService studentService;

    @GetMapping("/api/students")
    @ResponseBody()
    public List<Student> getStudentsList() {
        List<Student> students = this.studentService.getAllStudents("");
        return students;
    }

    @GetMapping("/api/students/{name}")
    @ResponseBody()
    public List<Student> getStudentsListByName(@PathVariable String name) {
        List<Student> students = this.studentService.getAllStudents(name);
        return students;
    }

    @PostMapping("/api/students")
    public ResponseEntity<Void> addStudent(@RequestBody Student student) {
        this.studentService.save(student);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
