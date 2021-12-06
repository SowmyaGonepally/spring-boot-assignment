package com.sowmya.librarysystem.controller;

import com.sowmya.librarysystem.dto.UserRegistrationDto;
import com.sowmya.librarysystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserRegistrationController {

    @Autowired
    private UserService userService;




    @GetMapping("/registerForm")
    public String showRegisterForm(Model model)
    {
        UserRegistrationDto user=new UserRegistrationDto();
        model.addAttribute("user",user);
        return "register-form";
    }

    @PostMapping("/registerUser")
    public String saveUser(@Valid @ModelAttribute("user") UserRegistrationDto userRegistrationDto, BindingResult bindingResult
    , Model model)
    {
        if(bindingResult.hasErrors())
        {
            model.addAttribute("user",userRegistrationDto);
            return "register-form";
        }
        userService.save(userRegistrationDto);
        return "reg-success";
    }
}
