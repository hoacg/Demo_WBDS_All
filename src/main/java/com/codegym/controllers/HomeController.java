package com.codegym.controllers;

import com.codegym.models.Student;
import com.codegym.services.IStudentService;
import com.codegym.validators.FacebookUserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    HttpSession httpSession;

    @ExceptionHandler(Exception.class)
    public String handleError(Exception e) {
        return "show-error";
    }

    private IStudentService studentService;

    HomeController(IStudentService studentService) {
        this.studentService = studentService;
    }

//    List<Student> getStudents() {
//        return studentService.getAllStudents("", 0, 0);
//    }

//    @GetMapping("/home")
//    public String getIndex(Model model) {
//        model.addAttribute("tech", "Thymeleaf và công nghệ khác.");
//        model.addAttribute("students", getStudents());
//        return "index";
//    }

//    @GetMapping("/student-list")
//    public String getStudentList(Model model) {
//
//        Object isSignedIn = httpSession.getAttribute("isSignedIn");
//
//        if (isSignedIn != null) {
//            model.addAttribute("students", getStudents());
//            return "student-list";
//        } else {
//            return "redirect:/signin";
//        }
//    }

    @GetMapping("/student-add")
    public ModelAndView getStudentAdd() {
        ModelAndView addView = new ModelAndView("student-add");
        addView.addObject("student", new Student());
        return addView;
    }


    @PostMapping("/student-add")
    public ModelAndView saveStudent(@Validated @ModelAttribute Student student, BindingResult bindingResult) {

        new FacebookUserValidator().validate(student, bindingResult); // kiểm tra đường dẫn FB

        if (bindingResult.hasFieldErrors()) {
            String message = "Có lỗi xảy ra";
            ModelAndView addView = new ModelAndView("student-add");
            addView.addObject("message", message);
            return addView;
        }
        studentService.save(student);

        return new ModelAndView("redirect:/student-list");
    }

    @GetMapping("/students/{id}")
    public String getStudentDetail(@PathVariable("id") Long student, Model model) {
        model.addAttribute("student", student);
        return "student-detail";
    }

    @GetMapping("/students-ajax")
    public String getStudentAjax() {
        return "demo_ajax";
    }


}
