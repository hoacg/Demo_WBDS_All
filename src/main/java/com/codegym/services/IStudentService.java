package com.codegym.services;

import com.codegym.models.Student;

import java.util.List;

public interface IStudentService {
    List<Student> getAllStudents(String startWithText, int size, int page);
    Student save(Student student);
}
