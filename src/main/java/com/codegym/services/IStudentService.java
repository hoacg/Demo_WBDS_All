package com.codegym.services;

import com.codegym.models.Student;

import java.util.List;

public interface IStudentService {
    List<Student> getAllStudents(String startWithText);
    Student save(Student student);
}
