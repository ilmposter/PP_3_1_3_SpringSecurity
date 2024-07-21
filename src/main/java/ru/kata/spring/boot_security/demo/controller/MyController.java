package ru.kata.spring.boot_security.demo.controller;

import com.springboot.PP2_3_1_Boot.model.User;
import com.springboot.PP2_3_1_Boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class MyController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String startPage() {
        return "redirect:/register";
    }

    @GetMapping("/users")
    public String listUsers(Model model) {
        model.addAttribute("users", userService.listUsers());
        return "users";
    }

    @GetMapping("/register")
    public String showRegistrationForm() {
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user, Model model) {
        userService.add(user);
        model.addAttribute("firstName", user.getFirstName());
        model.addAttribute("lastName", user.getLastName());
        model.addAttribute("age", user.getAge());
        return "registration-success";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam long id) {
        User user = userService.findById(id);
        if (user != null) {
            userService.delete(user);
        }
        return "redirect:/users";
    }

    @PostMapping("/update")
    public String updateUser(@ModelAttribute User user) {
        User updateUser = userService.findById(user.getId());
        if (updateUser != null) {
            updateUser.setFirstName(user.getFirstName());
            updateUser.setLastName(user.getLastName());
            updateUser.setAge(user.getAge());
            userService.update(updateUser);
        }
        return "redirect:/users";
    }

}

