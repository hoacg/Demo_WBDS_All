package com.codegym.repositories;

import com.codegym.models.Student;

import java.util.List;

public interface IStudentRepository {
    public List<Student> getAllStudents();
    public List<Student> getAllStudentsStartWith(String character);
}
