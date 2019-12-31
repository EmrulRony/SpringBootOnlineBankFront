package com.yas.onlinebankfront.controllers;

import java.util.HashSet;
import java.util.Set;

import com.yas.onlinebankfront.dao.RoleDao;
import com.yas.onlinebankfront.entities.User;
import com.yas.onlinebankfront.entities.security.UserRole;
import com.yas.onlinebankfront.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController{
    private static final Logger LOG = LoggerFactory.getLogger(UserService.class);
    @Autowired
    UserService userService;
    @Autowired
    RoleDao roleDao;

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
                LOG.info("Inside username check");
                System.out.println();
                model.addAttribute("userNameExists", true);
            }
            if (userService.checkEmailExists(user.getEmail())){
                model.addAttribute("emailExists", true);
            }
            model.addAttribute("user",user);
            return "signup";
        }
        Set<UserRole> userRoles = new HashSet<>();
        userRoles.add(new UserRole(user,roleDao.findByName("ROLE_USER")));
        userService.createUser(user, userRoles);
        model.addAttribute("success", true);
        user = null;
        return "redirect:/signup";
    }

}