package org.example.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    // user dashboard
    @GetMapping("/dashboard")
    public String userDashboard() {
        return "user/dashboard";
    }
    // user add contact

    // user view contact
}
