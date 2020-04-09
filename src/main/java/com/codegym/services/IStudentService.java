package com.codegym.services;

import com.codegym.models.Student;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IStudentService {
    Page<Student> getAllStudents(String startWithText, int size, int page);
    Student save(Student student);
}
