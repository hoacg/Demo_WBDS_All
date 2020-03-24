package com.codegym.repositories;

import com.codegym.models.Student;

import java.util.List;

public class StudentRealRepository implements IStudentRepository {
    @Override
    public List<Student> getAllStudents() {
        // SQL = "SELECT * FROM Students";
        return null;
    }

    @Override
    public List<Student> getAllStudentsStartWith(String character) {
        // SQL = "SELECT * FROM Students WHERE name LIKE '" + characters + "%';
        return null;
    }
}
