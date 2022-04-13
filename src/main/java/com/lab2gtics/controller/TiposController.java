package com.lab2gtics.controller;

import com.lab2gtics.entity.Tipo;
import com.lab2gtics.repository.TiposRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping(value = "/tipos")
public class TiposController {

    @Autowired
    TiposRepository tiposRepository;

    @RequestMapping("")
    public String listaTipos(Model model){
        model.addAttribute("listaequipo", tiposRepository.findAll());
        return "Tipos/listtipo";
    }

    @RequestMapping("/new")
    public String crearSede(){
        return "Tipos/newtipo";
    }
    @RequestMapping("/edit")
    public String editarListaSedes(Model model, RedirectAttributes attr, @RequestParam("id") Integer id ){
        Optional<Tipo> tipo = tiposRepository.findById(id);
        if(tipo.isPresent()){
            Tipo tipo1 = tipo.get();
            model.addAttribute("tipo", tipo1);
            return "Tipos/editipo";
        }else{
            attr.addFlashAttribute("msg","No se puede editar este objeto -missing id-");
            return "redirect:/tipos";
        }
    }
    @RequestMapping("/save")
    public String guardarSede(Tipo tipo, RedirectAttributes attr){
        if(tipo.getIdtipo() != null){
            attr.addFlashAttribute("accion","editar");
            attr.addFlashAttribute("msg","Tipo editado exitosamente");
        }else{
            attr.addFlashAttribute("accion","crear");
            attr.addFlashAttribute("msg","Tipo creado exitosamente");
        }
        tiposRepository.save(tipo);

        return "redirect:/tipos";
    }
    @RequestMapping("/delete")
    public String borrarListaSedes(RedirectAttributes attr,@RequestParam("id") Integer id){
        Optional<Tipo> tipo = tiposRepository.findById(id);
        if(tipo.isPresent()){
            tiposRepository.deleteById(id);
            attr.addFlashAttribute("msg","Tipo borrado exitosamente");
        }else{
            attr.addFlashAttribute("msg","Error al borrar -missing id-");
        }
        return "redirect:/tipos";
    }
}
