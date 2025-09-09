package com.sih.timetable.timetable.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.sih.timetable.timetable.model.User;

@Service
public class UserService {

    private final Map<String, User> users = new HashMap<>();

    public UserService() {
        // Hardcoded test users
        users.put("admin", new User("admin", "admin123", "ADMIN"));
        users.put("teacher", new User("teacher", "teacher123", "TEACHER"));
    }

    // 🔹 This must exist for LoginController to work
    public User authenticate(String username, String password, String role) {
        User u = users.get(username);
        if (u != null 
            && u.getPassword().equals(password) 
            && u.getRole().equalsIgnoreCase(role)) {
            return u;
        }
        return null;
    }
}
