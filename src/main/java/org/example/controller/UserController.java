package org.example.controller;

import org.example.model.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String tablePage(Model model){
        model.addAttribute("usersList", userService.getUsers());
        return "table";
    }

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

    @GetMapping("/updatePage")
    public String updatePage(
            @RequestParam("userId") Long id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "update";
    }

    @PostMapping("/update")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam("userId") Long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }
}
