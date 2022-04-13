package com.lab2gtics.controller;

import com.lab2gtics.entity.Inventario;
import com.lab2gtics.entity.Marca;
import com.lab2gtics.repository.InventarioRepository;
import com.lab2gtics.repository.MarcasRepository;
import com.lab2gtics.repository.SedesRepository;
import com.lab2gtics.repository.TiposRepository;
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
@RequestMapping("/inventario")
public class InventarioController {
    @Autowired
    InventarioRepository inventarioRepository;
    @Autowired
    SedesRepository sedesRepository;
    @Autowired
    MarcasRepository marcasRepository;
    @Autowired
    TiposRepository tiposRepository;

    @GetMapping("")
    public String listaInventario(Model model){
        model.addAttribute("listainventario", inventarioRepository.findAll());
        return "Inventario/lista";
    }

    @GetMapping("/new")
    public String crearInventario(Model model){
        model.addAttribute("sede", sedesRepository.findAll());
        model.addAttribute("marca", marcasRepository.findAll());
        model.addAttribute("tipo", tiposRepository.findAll());
        return "Inventario/nuevo";
    }
    @GetMapping("/edit")
    public String editarInventario(Model model, RedirectAttributes attr, @RequestParam("id") Integer id){
        Optional<Inventario> inventario = inventarioRepository.findById(id);
        if (inventario.isPresent()){
            model.addAttribute("inventario",inventario.get());
            model.addAttribute("sede", sedesRepository.findAll());
            model.addAttribute("marca", marcasRepository.findAll());
            model.addAttribute("tipo", tiposRepository.findAll());
            return "Inventario/editar";
        }
        return "redirect:/inventario";
    }

    @PostMapping("/save")
    public String marcaSave(Inventario inventario, RedirectAttributes attr){
        if(inventario.getIdinventario() != null){
            attr.addFlashAttribute("accion","alert-warning");
            attr.addFlashAttribute("msg", "Inventario editado exitosamente");
        } else {
            attr.addFlashAttribute("accion","alert-success");
            attr.addFlashAttribute("msg", "Inventario creado exitosamente");
        }
        inventarioRepository.save(inventario);
        return "redirect:/inventario";
    }

    @GetMapping("/delete")
    public String borrarMarca(@RequestParam("id") int id, RedirectAttributes attr){
        Optional<Inventario> optionalInventario = inventarioRepository.findById(id);
        if (optionalInventario.isPresent()){
            inventarioRepository.deleteById(id);
            attr.addFlashAttribute("accion","alert-danger");
            attr.addFlashAttribute("msg", "Inventario borrado exitosamente");
        }
        return "redirect:/inventario";
    }


}
