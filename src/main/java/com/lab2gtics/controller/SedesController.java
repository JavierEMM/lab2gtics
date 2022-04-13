package com.lab2gtics.controller;

import com.lab2gtics.repository.SedesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sedes")
public class SedesController {
    @Autowired
    SedesRepository sedesRepository;

    @RequestMapping("")
    public String listaSedes(Model model){

        model.addAttribute("listasedes", sedesRepository.findAll());
        return "Sedes/listasedes";
    }
}
