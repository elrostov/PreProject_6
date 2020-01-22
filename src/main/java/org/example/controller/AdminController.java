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

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    @PostMapping("/register")
    public String saveUser(User user,
                           @RequestParam("USER") String userRole,
                           @RequestParam(value = "ADMIN",
                                         required = false) String adminRole) {
        if ("".equals(user.getUsername()) ||
            "".equals(user.getPassword())) {
            return "register";
        }
        setRoles(user, userRole, adminRole);
        userService.saveUser(user);
        return "redirect:/admin/users";
    }

    @GetMapping("/update")
    public String updatePage(User user,
                             @RequestParam("USER") String userRole,
                             @RequestParam(value = "ADMIN",
                                           required = false) String adminRole, Model model) {
        setRoles(user, userRole, adminRole);
        model.addAttribute("user", user);
        return "update";
    }

    @PostMapping("/update")
    public String updateUser(User user,
                             @RequestParam("USER") String userRole,
                             @RequestParam(value = "ADMIN",
                                           required = false) String adminRole) {
        setRoles(user, userRole, adminRole);
        userService.updateUser(user);
        return "redirect:/admin/users";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam("userId") Long id) {
        userService.deleteUser(id);
        return "redirect:/admin/users";
    }

    private void setRoles(User user, String userRole, String adminRole) {
        if ("ADMIN".equals(adminRole)) {
            user.getRoles().add(roleService.getRole("ADMIN"));
        }
        if ("USER".equals(userRole)) {
            user.getRoles().add(roleService.getRole("USER"));
        }
    }
}
