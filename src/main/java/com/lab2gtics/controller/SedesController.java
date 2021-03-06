package com.lab2gtics.controller;

import com.lab2gtics.entity.Sede;
import com.lab2gtics.repository.SedesRepository;
import com.lab2gtics.repository.TrabajadoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/sedes")
public class SedesController {
    @Autowired
    SedesRepository sedesRepository;
    @Autowired
    TrabajadoresRepository trabajadoresRepository;

    @RequestMapping("")
    public String listaSedes(Model model){

        model.addAttribute("listasedes", sedesRepository.findAll());
        return "Sedes/listasedes";
    }
    @RequestMapping("/new")
    public String crearSede(){
        return "Sedes/newsede";
    }
    @RequestMapping("/edit")
    public String editarListaSedes(Model model, RedirectAttributes attr, @RequestParam("id") Integer id ){
        Optional<Sede> sede = sedesRepository.findById(id);
        if(sede.isPresent()){
            Sede sede1 = sede.get();
            model.addAttribute("sede", sede1);
            model.addAttribute("listatrabajadores",trabajadoresRepository.getTrabajadoresBySede(id));
            return "Sedes/editsede";
        }else{
            attr.addFlashAttribute("msg","No se puede editar este objeto -missing id-");
            return "redirect:/sedes";
        }
    }
    @RequestMapping("/save")
    public String guardarSede(Sede sede, RedirectAttributes attr){
        if(sede.getIdsede() != null){
            System.out.println("Id sede: "+ sede.getIdsede());
            attr.addFlashAttribute("accion","alert-warning");
            attr.addFlashAttribute("msg","Sede editada exitosamente");
        }else{
            attr.addFlashAttribute("accion","alert-success");
            attr.addFlashAttribute("msg","Sede creada exitosamente");
        }
        sedesRepository.save(sede);

        return "redirect:/sedes";
    }

    @RequestMapping("/delete")
    public String borrarListaSedes(Model model,RedirectAttributes attr,@RequestParam("id") Integer id){
        Optional<Sede> sede = sedesRepository.findById(id);
        if(sede.isPresent()){
            sedesRepository.deleteById(id);
            attr.addFlashAttribute("accion","alert-danger");
            attr.addFlashAttribute("msg","Sede borrada exitosamente");
        }else{
            attr.addFlashAttribute("msg","Error al borrar -missing id-");
        }
        return "redirect:/sedes";
    }
}
