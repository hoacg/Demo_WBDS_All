package com.codegym.services;

import com.codegym.models.Student;
import com.codegym.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

import java.util.List;

public class NewStudentService implements IStudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents(String startWithText) {
        return (List<Student>) this.studentRepository.findAll(Sort.by(Sort.Direction.DESC, "name"));
    }

    @Override
    public Student save(Student student) {
        return this.studentRepository.save(student);
    }
}
