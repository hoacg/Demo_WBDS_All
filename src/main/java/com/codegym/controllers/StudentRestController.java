package com.codegym.controllers;

import com.codegym.models.Pagination;
import com.codegym.models.Student;
import com.codegym.models.StudentResult;
import com.codegym.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
public class StudentRestController {

    @Autowired
    IStudentService studentService;

    @GetMapping("/api/students")
    @ResponseBody()
    public StudentResult getStudentsList(@RequestParam(defaultValue = "4") int size, @RequestParam(defaultValue = "0") int page) {

        Page<Student> students = this.studentService.getAllStudents("", size, page);

        StudentResult studentResult = new StudentResult();
        studentResult.setData(students.getContent());

        Pagination pagination = new Pagination();
        pagination.setPage(page);
        pagination.setSize(size);
        pagination.setTotal(students.getTotalElements());

        studentResult.setPagination(pagination);
        return studentResult;
    }

    @GetMapping("/api/students/{name}")
    @ResponseBody()
    public StudentResult getStudentsListByName(@PathVariable String name, @RequestParam(defaultValue = "4") int size, @RequestParam(defaultValue = "0") int page) {
        Page<Student> students = this.studentService.getAllStudents(name, size, page);

        StudentResult studentResult = new StudentResult();
        studentResult.setData(students.getContent());

        Pagination pagination = new Pagination();
        pagination.setPage(page);
        pagination.setSize(size);
        pagination.setTotal(students.getTotalElements());

        studentResult.setPagination(pagination);
        return studentResult;
    }

    @PostMapping("/api/students")
    public ResponseEntity<Void> addStudent(@RequestBody Student student) {
        this.studentService.save(student);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
