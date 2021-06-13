package com.example.sogne.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController
{
    /**
     * Returner index html siden når man rammer root endpoint http://localhost:8080/ med GetMapping
     */
    @GetMapping("/")
    public String index()
    {
        return "index";
    }
}
