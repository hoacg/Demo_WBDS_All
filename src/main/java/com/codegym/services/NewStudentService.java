package com.codegym.services;

import com.codegym.models.Student;
import com.codegym.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

public class NewStudentService implements IStudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents(String startWithText, int size, int page) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "name"));

        List<Student> studentsResult;

        if (startWithText.isEmpty()) {
            Page<Student> studentPage = this.studentRepository.findAll(pageable);
            studentsResult = studentPage.getContent();
        } else {
            Page<Student> studentPage = this.studentRepository.findAllByNameStartsWith(startWithText, pageable);
            studentsResult = studentPage.getContent();
        }

        return studentsResult;
    }

    @Override
    public Student save(Student student) {
        return this.studentRepository.save(student);
    }
}
