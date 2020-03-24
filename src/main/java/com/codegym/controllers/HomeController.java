package com.codegym.controllers;

import com.codegym.models.Student;
import com.codegym.repositories.IStudentRepository;
import com.codegym.services.IStudentService;
import com.codegym.services.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private IStudentService studentService;

    HomeController(IStudentService studentService) {
        this.studentService = studentService;
    }

    List<Student> getStudents() {
        return studentService.getAllStudents("");
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
