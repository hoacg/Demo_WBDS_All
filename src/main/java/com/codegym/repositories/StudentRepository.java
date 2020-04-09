package com.codegym.repositories;

import com.codegym.models.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface StudentRepository extends PagingAndSortingRepository<Student, Long> {
    Iterable<Student> findAllByNameStartsWith(String name);
    Page<Student> findAllByNameStartsWith(String name, Pageable pageable);
}
