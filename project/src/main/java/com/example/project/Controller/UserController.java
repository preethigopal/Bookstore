package com.example.project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import com.example.project.Entity.User;
import com.example.project.Repository.UserRepository;
import com.example.project.Service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
    
    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String getregisterpage(Model model){
        model.addAttribute("registerRequest", new User());
        return "register_page";
    }

     @GetMapping("/login")
    public String login(Model model){
         model.addAttribute("loginRequest", new User());
        return "login_page";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute User user) {
        System.out.println("register request" + user);
       User registeredUser = userService.registerUser(user.getLogin(), user.getPassword(), user.getEmail());
        return registeredUser == null ? "error_page" : "redirect:/login";
    }

     @PostMapping("/login")
    public String login(@ModelAttribute User user, Model model) {
        System.out.println("login request" + user);
       User authenticated = userService.authenticate(user.getLogin(), user.getPassword());
      if (authenticated != null) {
        model.addAttribute("userLogin", authenticated.getLogin());
        return "home";
      } else {
        return "error_page";
      }
    
}
}
