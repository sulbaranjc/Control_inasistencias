/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.controller;

import Codigo.Horario;
import Codigo.GestorHorario;
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
@RequestMapping("/horario")
public class ControllerHorario {
    GestorHorario ge = new GestorHorario ();
    
   @GetMapping("/crud")
 public String crud(Model model){
        String valorfinal="./horario/listarHorario";
        try {
            model.addAttribute("horarios", ge.listarFiltrados(""));
        } catch (SQLException ex) {
            Logger.getLogger(ControllerHorario.class.getName()).log(Level.SEVERE, null, ex);
            valorfinal="error";
        }
        return valorfinal;
  }
    
 @GetMapping("/alta")
  public String greetingForm(Model model) { 
    model.addAttribute("horario", new Horario()); 
  return "./horario/altaHorario";
  }
@PostMapping("/alta")
  public String greetingSubmit(@ModelAttribute Horario horario, Model model) { 
        String valorfinal="./horario/listarHorario";
        try {
            ge.alta(horario);
            try { 
                model.addAttribute("horarios", ge.listarFiltrados(""));
                model.addAttribute("filtro", "");
            } catch (SQLException ex) {
                Logger.getLogger(ControllerHorario.class.getName()).log(Level.SEVERE, null, ex);
                valorfinal="error";
            }
        } catch (SQLException ex) {
            valorfinal="error";
        }
    return valorfinal; 
  }
@GetMapping("/listar")
 public String listarAlumno(Model model){
        String valorfinal="./horario/listarHorario";
        try {
            model.addAttribute("horarios", ge.listarFiltrados(""));
        } catch (SQLException ex) {
            Logger.getLogger(ControllerHorario.class.getName()).log(Level.SEVERE, null, ex);
            valorfinal="error";
        }
        return valorfinal;
  }  
 @PostMapping("/listar")
 
 public String listarAlumnos(@RequestParam ("filtro") String filtro, Model model){
        String valorfinal="./horario/listarHorario";
        try {
            model.addAttribute("horarios", ge.listarFiltrados(filtro));
            model.addAttribute("filtro", filtro);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerHorario.class.getName()).log(Level.SEVERE, null, ex);
            valorfinal="error";
        }
        return valorfinal;
  }

  @GetMapping("/eliminar")
  public String SubmitB (@RequestParam ("codhorario") int id, Model model){
        String valorfinal="./horario/listarhorario";
        try {
            ge.eliminar(id);
             model.addAttribute("horarios", ge.listarFiltrados(""));
        } catch (SQLException ex) {
            valorfinal="error";
        }
        return valorfinal;
  } 
@GetMapping("/modificar")
  public String modificar(@RequestParam ("codhorario") int id,Model model){
        String valorfinal="./horario/modificarhorario";
        try {
            model.addAttribute("horario", ge.consultarUn(id));
        } catch (SQLException ex) {
            Logger.getLogger(ControllerHorario.class.getName()).log(Level.SEVERE, null, ex);
            valorfinal="error";
        }
         return valorfinal;
  } 
@PostMapping("/modificar")
  public String modificarBBDD (@ModelAttribute Horario horario, Model model){
        String valorfinal="./horario/listarhorario";
        try {
            ge.modificar(horario);
            model.addAttribute("horarios",ge.listarFiltrados(""));
        } catch (SQLException ex) {
            Logger.getLogger(ControllerHorario.class.getName()).log(Level.SEVERE, null, ex);
            valorfinal="error";
        }
        return valorfinal;
  }
  
}

