package com.codegym.services;

import com.codegym.models.Student;
import com.codegym.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class NewStudentService implements IStudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public Page<Student> getAllStudents(String startWithText, int size, int page) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "name"));

        if (startWithText.isEmpty()) {
            return this.studentRepository.findAll(pageable);
        } else {
            return this.studentRepository.findAllByNameStartsWith(startWithText, pageable);
        }
    }

    @Override
    public Student save(Student student) {
        return this.studentRepository.save(student);
    }
}
