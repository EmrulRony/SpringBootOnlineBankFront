package com.yas.onlinebankfront.controllers;

import com.yas.onlinebankfront.entities.User;
import com.yas.onlinebankfront.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController{
    @Autowired
    UserService userService;

    @RequestMapping("/")
    public String home(){
        return "redirect:/index";
    }

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/header")
    public String header(){
        return "common/header";
    }

    @GetMapping("/signup")
    public String signUp(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "signup";
    }

    @PostMapping("/signup")
    public String signUpPost(@ModelAttribute("user") User user, Model model){
        if (userService.checkUserExists(user.getUsername(), user.getEmail())){
            if (userService.checkUsernameExists(user.getUsername())){
                model.addAttribute("userName", true);
            }
            if (userService.checkEmailExists(user.getEmail())){
                model.addAttribute("email", true);
            }
            return "signup";
        }
        else{
            return "/";
        }
    }

}