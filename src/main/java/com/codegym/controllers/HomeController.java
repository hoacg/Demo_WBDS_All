package com.codegym.controllers;

import com.codegym.models.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    static List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Bằng"));
        students.add(new Student("Tú"));
        students.add(new Student("Linh"));
        students.add(new Student("Hoàng"));
        students.add(new Student("Khải"));

        return students;
    }

    @GetMapping("/home")
    public String getIndex(Model model) {
        model.addAttribute("tech", "Thymeleaf và công nghệ khác.");
        model.addAttribute("students", getStudents());
        return "index";
    }

    @GetMapping("/student-list")
    public String getStudentList(Model model) {
        model.addAttribute("students", getStudents());
        return "student-list";
    }

    @GetMapping("/student-add")
    public String getStudentAdd() {
        return "student-add";
    }

}
