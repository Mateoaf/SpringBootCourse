package com.example.reuniones.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AutenticacionController {

    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }
}
