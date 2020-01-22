package org.example.controller;

import org.example.model.Role;
import org.example.model.User;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.stream.Collectors;

@Controller
public class UserController {

    @GetMapping("/user")
    public String userPage(Model model, Authentication authentication){
        User user = (User) authentication.getPrincipal();
        model.addAttribute("user", user);
        return "user";
    }

    @GetMapping({"/login/process", "/"})
    public String login(Model model, Authentication authentication){
        User user = (User) authentication.getPrincipal();
        model.addAttribute("user", user);
        if (user.getRoles().stream()
                .map(Role::getName)
                .collect(Collectors.toList())
                .contains("ADMIN")) {
            return "redirect:/admin/users";
        }
        return "redirect:/user";
    }
}
