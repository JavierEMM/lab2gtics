package com.lab2gtics.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sedes")
public class SedesController {
    @RequestMapping("")
    public String listaSedes(){

        return "Sedes";
    }
}
