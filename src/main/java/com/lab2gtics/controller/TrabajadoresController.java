package com.lab2gtics.controller;

import com.lab2gtics.entity.Trabajadores;
import com.lab2gtics.repository.SedesRepository;
import com.lab2gtics.repository.TrabajadoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/trabajadores")
public class TrabajadoresController {

    @Autowired
    TrabajadoresRepository trabajadoresRepository;

    @Autowired
    SedesRepository sedesRepository;

    @GetMapping("/lista")
    public String listaTrabajadores(Model model){
        model.addAttribute("listaTrabajadores",trabajadoresRepository.findAll());
        return "/Trabajadores/lista";
    }

    @GetMapping("/nuevo")
    public String nuevoTrabajador(Model model){
        model.addAttribute("listaSedes",sedesRepository.findAll());
        return "/Trabajadores/nuevo";
    }

    @PostMapping("/guardar")
    public String guardarTrabajador(Trabajadores trabajadores){
        trabajadoresRepository.save(trabajadores);
        return "redirect:/trabajadores/lista";
    }

    @GetMapping("/editar")
    public String editarTrabajador(@RequestParam("id") String id, Model model){
        Optional<Trabajadores> optionalTrabajadores=trabajadoresRepository.findById(id);
        if(optionalTrabajadores.isPresent()){
            Trabajadores trabajadores=optionalTrabajadores.get();
            model.addAttribute("trabajador",trabajadores);
            model.addAttribute("listaSedes",sedesRepository.findAll());
            return "/Trabajadores/editar";
        }else{
            return "redirect:/trabajadores/lista";
        }
    }

    @GetMapping("/borrar")
    public String borrarTrabajador(@RequestParam("id") String id, Model model){
        Optional<Trabajadores> optionalTrabajadores=trabajadoresRepository.findById(id);
        if(optionalTrabajadores.isPresent()){
            trabajadoresRepository.deleteById(id);

        }
        return "redirect:/trabajadores/lista";
    }

}
