package com.sowmya.librarysystem.controller;

import com.sowmya.librarysystem.service.UserService;
import com.sowmya.librarysystem.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserLoginController {


    @Autowired
    private UserService userService;

    @GetMapping("/loginForm")
    public String showLoginForm(Model model)
    {
        User user=new User();
        model.addAttribute("user",user);
        return "login-form";
    }

    @GetMapping("/welcome")
    public String welcome()
    {
        return "welcome";
    }








}
