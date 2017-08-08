package com.codeup.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloWorldController {


    @GetMapping("/resume")
    public String showResume() {
        return "resume";
    }

    @GetMapping("/portfolio")
    public String showPortfolio() {
        return "portfolio";
    }

    @GetMapping("/contact")
    public String showContact() {
        return "contact";
    }

    @GetMapping("/aboutme")
    public String showAboutMe() {
        return "aboutme";
    }

    @GetMapping("/")
    public String hello() {
        return "index";
    }
}

