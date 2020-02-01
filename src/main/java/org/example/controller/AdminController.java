package org.example.controller;

import org.example.model.User;
import org.example.service.RoleService;
import org.example.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;
    private final RoleService roleService;

    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/users")
    public String adminPage(Model model){
        List<User> users = userService.getUsers();
        model.addAttribute("usersList", users);
        return "admin";
    }

    @PostMapping("/register")
    public String saveUser(User user, @RequestParam(value="userRoles", required = false) String[] userRoles) {
        if ("".equals(user.getUsername()) ||
            "".equals(user.getPassword()) ||
            "".equals(user.getEmail()) ||
            userRoles.length == 0) {
            return "redirect:/admin/users";
        }
        setRoles(user, userRoles);
        userService.saveUser(user);
        return "redirect:/admin/users";
    }

    @PostMapping("/update")
    public String updateUser(User user, @RequestParam("userRoles") String[] userRoles) {
        setRoles(user, userRoles);
        userService.updateUser(user);
        return "redirect:/admin/users";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam("userId") Long id) {
        userService.deleteUser(id);
        return "redirect:/admin/users";
    }

    private void setRoles(User user, String[] roles) {
        for (String role : roles) {
            user.getRoles().add(roleService.getRole(role));
        }
    }
}
