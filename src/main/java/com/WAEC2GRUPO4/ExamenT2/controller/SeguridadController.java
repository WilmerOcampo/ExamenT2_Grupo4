package com.WAEC2GRUPO4.ExamenT2.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SeguridadController {
    @GetMapping("register")
    public String register(){
        return "register";
    }
}
