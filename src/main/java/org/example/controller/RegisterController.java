package org.example.controller;

import org.example.model.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("userForm", new User());
        return "register";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("userForm") User user) {
        if (user.getName().equals("") ||
            user.getPassword().equals("") ||
            user.getRole().equals("")) {
            return "redirect:/register";
        }
        userService.saveUser(user);
        return "redirect:/";
    }
}
