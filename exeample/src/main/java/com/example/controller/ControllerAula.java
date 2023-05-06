/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.controller;

import Codigo.Aula;
import Codigo.GestorAula;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Michelli Fernanda
 */
@Controller
@RequestMapping("/aula")
public class ControllerAula {
    GestorAula ge = new GestorAula ();
    
   @GetMapping("/crud")
 public String crud(Model model){
        String valorfinal="./aula/listarAula";
        try {
            model.addAttribute("aulas", ge.listarFiltrados(""));
        } catch (SQLException ex) {
            Logger.getLogger(ControllerAula.class.getName()).log(Level.SEVERE, null, ex);
            valorfinal="error";
        }
        return valorfinal;
  }
    
 @GetMapping("/alta")
  public String greetingForm(Model model) { 
    model.addAttribute("aula", new Aula()); 
  return "./aula/altaAula";
  }
@PostMapping("/alta")
  public String greetingSubmit(@ModelAttribute Aula aula, Model model) { 
        String valorfinal="./aula/listarAula";
        try {
            ge.alta(aula);
            try { 
                model.addAttribute("aulas", ge.listarFiltrados(""));
                model.addAttribute("filtro", "");
            } catch (SQLException ex) {
                Logger.getLogger(ControllerAula.class.getName()).log(Level.SEVERE, null, ex);
                valorfinal="error";
            }
        } catch (SQLException ex) {
            valorfinal="error";
        }
    return valorfinal; 
  }
@GetMapping("/listar")
 public String listarAlumno(Model model){
        String valorfinal="./aula/listarAula";
        try {
            model.addAttribute("aulas", ge.listarFiltrados(""));
        } catch (SQLException ex) {
            Logger.getLogger(ControllerAula.class.getName()).log(Level.SEVERE, null, ex);
            valorfinal="error";
        }
        return valorfinal;
  }  
 @PostMapping("/listar")
 
 public String listarAlumnos(@RequestParam ("filtro") String filtro, Model model){
        String valorfinal="./aula/listarAula";
        try {
            model.addAttribute("aulas", ge.listarFiltrados(filtro));
            model.addAttribute("filtro", filtro);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerAula.class.getName()).log(Level.SEVERE, null, ex);
            valorfinal="error";
        }
        return valorfinal;
  }

  @GetMapping("/eliminar")
  public String SubmitB (@RequestParam ("codaula") int id, Model model){
        String valorfinal="./aula/listaraula";
        try {
            ge.eliminar(id);
             model.addAttribute("aulas", ge.listarFiltrados(""));
        } catch (SQLException ex) {
            valorfinal="error";
        }
        return valorfinal;
  } 
@GetMapping("/modificar")
  public String modificar(@RequestParam ("codaula") int id,Model model){
        String valorfinal="./aula/modificaraula";
        try {
            model.addAttribute("aula", ge.consultarUn(id));
        } catch (SQLException ex) {
            Logger.getLogger(ControllerAula.class.getName()).log(Level.SEVERE, null, ex);
            valorfinal="error";
        }
         return valorfinal;
  } 
@PostMapping("/modificar")
  public String modificarBBDD (@ModelAttribute Aula aula, Model model){
        String valorfinal="./aula/listaraula";
        try {
            ge.modificar(aula);
            model.addAttribute("aulas",ge.listarFiltrados(""));
        } catch (SQLException ex) {
            Logger.getLogger(ControllerAula.class.getName()).log(Level.SEVERE, null, ex);
            valorfinal="error";
        }
        return valorfinal;
  }
  
}

