package org.example.controller;

import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class TablePageController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String tablePage(Model model){
        model.addAttribute("usersList", userService.getUsers());
        return "table";
    }
}
