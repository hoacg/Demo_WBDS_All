package com.codegym.repositories.old;

import com.codegym.models.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements IStudentRepository {

    public List<Student> getAllStudents() {

        // SQL = "SELECT * FROM Students";

        // ==> MySQL Tables >>> List
        List<Student> students = new ArrayList<>();

        students.add(new Student("Bằng"));
        students.add(new Student("Tú"));
        students.add(new Student("Linh"));
        students.add(new Student("Hoàng"));
        students.add(new Student("Khải"));

        return students;
    }

    public List<Student> getAllStudentsStartWith(String character) {

        // SQL = "SELECT * FROM Students WHERE name LIKE '" + characters + "%';

        // ==> MySQL Tables >>> List
        List<Student> students = new ArrayList<>();
        students.add(new Student("Hoàng"));

        return students;
    }

    @Override
    public Student save(Student student) {
        return null;
    }

}
