package com.codegym.services;

import com.codegym.models.Student;
import com.codegym.repositories.IStudentRepository;
import com.codegym.repositories.StudentRepository;

import java.util.List;

public class StudentService implements IStudentService {

    private IStudentRepository studentRepository;

    public StudentService(IStudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents(String startWithText) {

        if (startWithText.equals("") || startWithText.isEmpty()) {
            return studentRepository.getAllStudents();
        } else {
            return studentRepository.getAllStudentsStartWith(startWithText);
        }

    }

}
