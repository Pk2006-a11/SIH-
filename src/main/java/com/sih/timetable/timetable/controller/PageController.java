package com.sih.timetable.timetable.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/")
    public String home() {
        return "index"; // loads templates/index.html
    }

    @GetMapping("/admin/login")
    public String adminLoginPage() {
        return "admin-login"; // loads templates/admin-login.html
    }

    @GetMapping("/teacher/login")
    public String teacherLoginPage() {
        return "teacher-login"; // loads templates/teacher-login.html
    }
}
