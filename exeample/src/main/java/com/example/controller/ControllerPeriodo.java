/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.controller;

import Codigo.Periodo;
import Codigo.GestorPeriodo;
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
 * @author Michelli fernanda
 */
@Controller
@RequestMapping("/periodo")
public class ControllerPeriodo {
    GestorPeriodo ge = new GestorPeriodo ();
    
   @GetMapping("/crud")
 public String crud(Model model){
        String valorfinal="./periodo/listarPeriodo";
        try {
            model.addAttribute("periodos", ge.listarFiltrados(""));
        } catch (SQLException ex) {
            Logger.getLogger(ControllerPeriodo.class.getName()).log(Level.SEVERE, null, ex);
            valorfinal="error";
        }
        return valorfinal;
  }
    
 @GetMapping("/alta")
  public String greetingForm(Model model) { 
    model.addAttribute("periodo", new Periodo()); 
  return "./periodo/altaPeriodo";
  }
@PostMapping("/alta")
  public String greetingSubmit(@ModelAttribute Periodo periodo, Model model) { 
        String valorfinal="./periodo/listarPeriodo";
        try {
            ge.alta(periodo);
            try { 
                model.addAttribute("periodos", ge.listarFiltrados(""));
                model.addAttribute("filtro", "");
            } catch (SQLException ex) {
                Logger.getLogger(ControllerPeriodo.class.getName()).log(Level.SEVERE, null, ex);
                valorfinal="error";
            }
        } catch (SQLException ex) {
            valorfinal="error";
        }
    return valorfinal; 
  }
@GetMapping("/listar")
 public String listarAlumno(Model model){
        String valorfinal="./periodo/listarPeriodo";
        try {
            model.addAttribute("periodos", ge.listarFiltrados(""));
        } catch (SQLException ex) {
            Logger.getLogger(ControllerPeriodo.class.getName()).log(Level.SEVERE, null, ex);
            valorfinal="error";
        }
        return valorfinal;
  }  
 @PostMapping("/listar")
 
 public String listarAlumnos(@RequestParam ("filtro") String filtro, Model model){
        String valorfinal="./periodo/listarPeriodo";
        try {
            model.addAttribute("periodos", ge.listarFiltrados(filtro));
            model.addAttribute("filtro", filtro);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerPeriodo.class.getName()).log(Level.SEVERE, null, ex);
            valorfinal="error";
        }
        return valorfinal;
  }

  @GetMapping("/eliminar")
  public String SubmitB (@RequestParam ("codperiodo") int id, Model model){
        String valorfinal="./periodo/listarperiodo";
        try {
            ge.eliminar(id);
             model.addAttribute("periodos", ge.listarFiltrados(""));
        } catch (SQLException ex) {
            valorfinal="error";
        }
        return valorfinal;
  } 
@GetMapping("/modificar")
  public String modificar(@RequestParam ("codperiodo") int id,Model model){
        String valorfinal="./periodo/modificarperiodo";
        try {
            model.addAttribute("periodo", ge.consultarUn(id));
        } catch (SQLException ex) {
            Logger.getLogger(ControllerPeriodo.class.getName()).log(Level.SEVERE, null, ex);
            valorfinal="error";
        }
         return valorfinal;
  } 
@PostMapping("/modificar")
  public String modificarBBDD (@ModelAttribute Periodo periodo, Model model){
        String valorfinal="./periodo/listarperiodo";
        try {
            ge.modificar(periodo);
            model.addAttribute("periodos",ge.listarFiltrados(""));
        } catch (SQLException ex) {
            Logger.getLogger(ControllerPeriodo.class.getName()).log(Level.SEVERE, null, ex);
            valorfinal="error";
        }
        return valorfinal;
  }
  
}

