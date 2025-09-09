package com.sih.timetable.timetable.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sih.timetable.timetable.model.User;
import com.sih.timetable.timetable.service.UserService;

@Controller
public class LoginController {

    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    // ===========================
    // Show login pages
    // ===========================
    @GetMapping("/admin/login-page")
    public String showAdminLogin() {
        // Will load static/admin/admin-login.html
        return "admin/admin-login.html";
    }

    @GetMapping("/teacher/login-page")
    public String showTeacherLogin() {
        // Will load static/teacher/teacher-login.html
        return "teacher/teacher-login.html";
    }

    // ===========================
    // Handle login forms
    // ===========================
    @PostMapping("/admin/login")
    public String adminLogin(@RequestParam String username,
                             @RequestParam String password) {
        User user = userService.authenticate(username, password, "ADMIN");
        if (user != null) {
            return "redirect:/admin/dashboard"; // success page
        }
        return "redirect:/admin/login-page?error"; // back with error
    }

    @PostMapping("/teacher/login")
    public String teacherLogin(@RequestParam String username,
                               @RequestParam String password) {
        User user = userService.authenticate(username, password, "TEACHER");
        if (user != null) {
            return "redirect:/teacher/dashboard"; // success page
        }
        return "redirect:/teacher/login-page?error";
    }

    // ===========================
    // Dashboards
    // ===========================
    @GetMapping("/admin/dashboard")
    @ResponseBody
    public String adminDashboard() {
        return "<h1>Welcome Admin</h1>";
    }

    @GetMapping("/teacher/dashboard")
    @ResponseBody
    public String teacherDashboard() {
        return "<h1>Welcome Teacher</h1>";
    }
}
