/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.controller;

import Codigo.Turno;
import Codigo.GestorTurno;
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
 * @author sulbaranjc
 */
@Controller
@RequestMapping("/turno")
public class ControllerTurno {
    GestorTurno ge = new GestorTurno ();
    
   @GetMapping("/crud")
 public String crud(Model model){
        String valorfinal="./turno/listarTurno";
        try {
            model.addAttribute("turnos", ge.listarFiltrados(""));
        } catch (SQLException ex) {
            Logger.getLogger(ControllerTurno.class.getName()).log(Level.SEVERE, null, ex);
            valorfinal="error";
        }
        return valorfinal;
  }
    
 @GetMapping("/alta")
  public String greetingForm(Model model) { 
    model.addAttribute("turno", new Turno()); 
  return "./turno/altaTurno";
  }
@PostMapping("/alta")
  public String greetingSubmit(@ModelAttribute Turno turno, Model model) { 
        String valorfinal="./turno/listarTurno";
        try {
            ge.alta(turno);
            try { 
                model.addAttribute("turnos", ge.listarFiltrados(""));
                model.addAttribute("filtro", "");
            } catch (SQLException ex) {
                Logger.getLogger(ControllerTurno.class.getName()).log(Level.SEVERE, null, ex);
                valorfinal="error";
            }
        } catch (SQLException ex) {
            valorfinal="error";
        }
    return valorfinal; 
  }
@GetMapping("/listar")
 public String listarAlumno(Model model){
        String valorfinal="./turno/listarTurno";
        try {
            model.addAttribute("turnos", ge.listarFiltrados(""));
        } catch (SQLException ex) {
            Logger.getLogger(ControllerTurno.class.getName()).log(Level.SEVERE, null, ex);
            valorfinal="error";
        }
        return valorfinal;
  }  
 @PostMapping("/listar")
 
 public String listarAlumnos(@RequestParam ("filtro") String filtro, Model model){
        String valorfinal="./turno/listarTurno";
        try {
            model.addAttribute("turnos", ge.listarFiltrados(filtro));
            model.addAttribute("filtro", filtro);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerTurno.class.getName()).log(Level.SEVERE, null, ex);
            valorfinal="error";
        }
        return valorfinal;
  }

  @GetMapping("/eliminar")
  public String SubmitB (@RequestParam ("codturno") int id, Model model){
        String valorfinal="./turno/listarturno";
        try {
            ge.eliminar(id);
             model.addAttribute("turnos", ge.listarFiltrados(""));
        } catch (SQLException ex) {
            valorfinal="error";
        }
        return valorfinal;
  } 
@GetMapping("/modificar")
  public String modificar(@RequestParam ("codturno") int id,Model model){
        String valorfinal="./turno/modificarturno";
        try {
            model.addAttribute("turno", ge.consultarUn(id));
        } catch (SQLException ex) {
            Logger.getLogger(ControllerTurno.class.getName()).log(Level.SEVERE, null, ex);
            valorfinal="error";
        }
         return valorfinal;
  } 
@PostMapping("/modificar")
  public String modificarBBDD (@ModelAttribute Turno turno, Model model){
        String valorfinal="./turno/listarturno";
        try {
            ge.modificar(turno);
            model.addAttribute("turnos",ge.listarFiltrados(""));
        } catch (SQLException ex) {
            Logger.getLogger(ControllerTurno.class.getName()).log(Level.SEVERE, null, ex);
            valorfinal="error";
        }
        return valorfinal;
  }
  
}

