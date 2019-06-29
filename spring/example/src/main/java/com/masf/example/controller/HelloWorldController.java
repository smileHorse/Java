package com.masf.example.controller;

import com.masf.example.entity.User;
import com.masf.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/test")
public class HelloWorldController {
    @Autowired
    UserService userService;

    @RequestMapping("/index.html")
    public String say(Model model) {
        model.addAttribute("name", "hello world");
        return "/index.btl";
    }

    @RequestMapping("/index.json")
    public @ResponseBody String say() {
        return "hello, world";
    }

    @RequestMapping(path = "/all.json", method = RequestMethod.GET)
    public @ResponseBody List<User> allUser() {
        return userService.allUser();
    }
}
