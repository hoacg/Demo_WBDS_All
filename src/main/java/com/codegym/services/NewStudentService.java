package com.codegym.services;

import com.codegym.models.Student;
import com.codegym.repositories.StudentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Optional;

public class NewStudentService implements IStudentService {

    private StudentRepository studentRepository;

    public NewStudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

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

    @Override
    public Student getStudentById(Long id) {

        Optional<Student> studentOptional = this.studentRepository.findById(id);

        if (studentOptional.isPresent()) {
            return studentOptional.get();
        } else {
            throw new RuntimeException("Không tìm thấy sinh viên có id = " + id);
        }
    }
}
