package com.codegym.controllers;

import com.codegym.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    HttpSession httpSession;

    @GetMapping("/signin")
    public String getSigninForm(@CookieValue(defaultValue = "") String email, @CookieValue(defaultValue = "") String password, Model model) {
        model.addAttribute("email", email);
        model.addAttribute("password", password);
        model.addAttribute("message", "");
        return "sign-in";
    }

    @PostMapping("/signin")
    public String doSignin(@ModelAttribute User user, @RequestParam(defaultValue = "") String rememberMe, HttpServletResponse response, Model model) {

        if (user.getEmail().equals("admin@codegym.vn") && user.getPassword().equals("admin")) {
            httpSession.setAttribute("isSignedIn", true);

            if (rememberMe.equals("remember-me")) {
                Cookie savedEmail = new Cookie("email", user.getEmail());
                Cookie savedPassword = new Cookie("password", user.getPassword());

                response.addCookie(savedEmail);
                response.addCookie(savedPassword);
            }

            model.addAttribute("message", "Đăng nhập thành công");
            return "redirect:/";
        } else {
            model.addAttribute("message", "Đăng nhập không thành công");
            return "sign-in";
        }
    }

}
