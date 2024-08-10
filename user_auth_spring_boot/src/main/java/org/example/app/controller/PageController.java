package org.example.app.controller;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.example.app.entities.User;
import org.example.app.forms.UserForm;
import org.example.app.helper.Message;
import org.example.app.helper.MessageType;
import org.example.app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class PageController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index() {
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String home() {
        System.out.println("Home page handler");
        return "home";
    }

     @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("isLogin", true);
        System.out.println("About us");
        return "about";
    }

    @GetMapping("/services")
    public String services(Model model) {
        model.addAttribute("s1", "Web dev");
        return "services";
    }

     @GetMapping("contact")
    public String contact() {
        return "contact";
    }

    @GetMapping("login")
    public String login() {
        return "login";
    }

     @GetMapping("register")
    public String register(Model model) {
        // send data from Controller to view through Model
        // set-default data
        UserForm userForm = new UserForm();
        model.addAttribute("userForm", userForm);
        return "register";
    }

    @PostMapping("/do-register")
    public String processRegister(@Valid @ModelAttribute UserForm userForm, BindingResult bindingResult, HttpSession session) {
        System.out.println("Processing registration");

        // validate form data
        if(bindingResult.hasErrors()) {
            return "register";
        }
        // fetch form data in UserForm
        User user = new User();
        user.setName(userForm.getName());
        user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());
        user.setPhoneNumber(userForm.getPhoneNumber());
        user.setAbout(userForm.getAbout());
        // save data
         User savedUser = userService.saveUser(user);
         System.out.println("User Saved");

         // add message
        Message message = Message.builder().content("Registration successful").type(MessageType.green).build();
        session.setAttribute("message", message);

        // redirect login page
        return "redirect:register";
    }
}
