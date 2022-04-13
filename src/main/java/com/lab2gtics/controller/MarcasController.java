package com.lab2gtics.controller;

import com.lab2gtics.entity.Marca;
import com.lab2gtics.repository.MarcasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/marca")
public class MarcasController {

    @Autowired
    MarcasRepository marcasRepository;

    @GetMapping("")
    public String marcaList(Model model){
        model.addAttribute("marcaList", marcasRepository.findAll());

        return "Marcas/lista";
    }

    @GetMapping("/new")
    public String marcaNew(){
        return "Marcas/nuevo";
    }

    @PostMapping("/save")
    public String marcaSave(Marca marca, RedirectAttributes attr){
        if(marca.getIdmarca() != null){
            attr.addFlashAttribute("msg", "Marca actualizada exitosamente");
        } else {
            attr.addFlashAttribute("msg2", "Marca creada exitosamente");
        }
        marcasRepository.save(marca);
        return "redirect:/marca";
    }

    @GetMapping("/edit")
    public String editMarca(@RequestParam("id") int id, Model model) {
        Optional<Marca> marcaOptional = marcasRepository.findById(id);

        if (marcaOptional.isPresent()){
            Marca marca = marcaOptional.get();
            model.addAttribute("marca", marca);
            return "Marcas/editar";
        }else{
            return "redirect:/marca";
        }
    }

    @GetMapping("/delete")
    public String borrarMarca(@RequestParam("id") int id, RedirectAttributes attr1){
        Optional<Marca> optionalMarca = marcasRepository.findById(id);
        if (optionalMarca.isPresent()){
            marcasRepository.deleteById(id);
            attr1.addFlashAttribute("msg3", "Marca borrada exitosamente");
        }
        return "redirect:/marca";
    }


}
