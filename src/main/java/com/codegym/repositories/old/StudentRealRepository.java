package com.codegym.repositories.old;

import com.codegym.models.Student;
import com.codegym.repositories.old.mysql.MySQLConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentRealRepository implements IStudentRepository {

    private MySQLConnection mySQLConnection;

    public StudentRealRepository() {
        try {
            this.mySQLConnection = MySQLConnection.getInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Student> getAllStudents() {
        return queryStudents("SELECT * FROM students");
    }

    @Override
    public List<Student> getAllStudentsStartWith(String character) {
        return queryStudents("SELECT * FROM students WHERE name LIKE '" + character + "%'");
    }

    @Override
    public Student save(Student student) {
        return null;
    }


    private List<Student> queryStudents(String query) {
        List<Student> students = new ArrayList<>();

        Statement statement = null;
        try {
            statement = this.mySQLConnection.getStatement();

            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                String name = rs.getString(1);
                Student student = new Student(name);
                students.add(student);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
}
