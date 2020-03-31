package com.codegym.controllers;

import com.codegym.models.Student;
import com.codegym.services.IStudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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


    @PostMapping("/student-add")
    public String saveStudent(@ModelAttribute Student student) {
        studentService.save(student);

        return "redirect:/student-list";
    }

    @GetMapping("/students/{id}")
    public String getStudentDetail(@PathVariable("id") Student student, Model model) {
        model.addAttribute("student", student);
        return "student-detail";
    }

}
