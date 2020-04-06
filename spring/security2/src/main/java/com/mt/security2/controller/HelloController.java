package com.mt.security2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/admin/hello")
    public String admin() {
        return "Hello admin!";
    }

    @GetMapping("/db/hello")
    public String dba() {
        return "Hello dba!";
    }

    @GetMapping("/user/hello")
    public String user() {
        return "Hello user!";
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello !";
    }
}
