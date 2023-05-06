/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.controller;

import Codigo.Fp;
import Codigo.GestorFp;
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
@RequestMapping("/fp")
public class ControllerFp {
    GestorFp ge = new GestorFp ();
    
   @GetMapping("/crud")
 public String crud(Model model){
        String valorfinal="./fp/listarFp";
        try {
            model.addAttribute("fps", ge.listarFiltrados(""));
        } catch (SQLException ex) {
            Logger.getLogger(controller1.class.getName()).log(Level.SEVERE, null, ex);
            valorfinal="error";
        }
        return valorfinal;
  }
    
 @GetMapping("/alta")
  public String greetingForm(Model model) { 
    model.addAttribute("fp", new Fp()); 
  return "./fp/altaFp";
  }
@PostMapping("/alta")
  public String greetingSubmit(@ModelAttribute Fp fp, Model model) { 
        String valorfinal="./fp/listarFp";
        try {
            ge.alta(fp);
            try { 
                model.addAttribute("fps", ge.listarFiltrados(""));
                model.addAttribute("filtro", "");
            } catch (SQLException ex) {
                Logger.getLogger(controller1.class.getName()).log(Level.SEVERE, null, ex);
                valorfinal="error";
            }
        } catch (SQLException ex) {
            valorfinal="error";
        }
    return valorfinal; 
  }
@GetMapping("/listar")
 public String listarAlumno(Model model){
        String valorfinal="./fp/listarFp";
        try {
            model.addAttribute("fps", ge.listarFiltrados(""));
        } catch (SQLException ex) {
            Logger.getLogger(controller1.class.getName()).log(Level.SEVERE, null, ex);
            valorfinal="error";
        }
        return valorfinal;
  }  
 @PostMapping("/listar")
 
 public String listarAlumnos(@RequestParam ("filtro") String filtro, Model model){
        String valorfinal="./fp/listarFp";
        try {
            model.addAttribute("fps", ge.listarFiltrados(filtro));
            model.addAttribute("filtro", filtro);
        } catch (SQLException ex) {
            Logger.getLogger(controller1.class.getName()).log(Level.SEVERE, null, ex);
            valorfinal="error";
        }
        return valorfinal;
  }

  @GetMapping("/eliminar")
  public String SubmitB (@RequestParam ("codfp") int id, Model model){
        String valorfinal="./fp/listarfp";
        try {
            ge.eliminar(id);
             model.addAttribute("fps", ge.listarFiltrados(""));
        } catch (SQLException ex) {
            valorfinal="error";
        }
        return valorfinal;
  } 
@GetMapping("/modificar")
  public String modificar(@RequestParam ("codfp") int id,Model model){
        String valorfinal="./fp/modificarfp";
        try {
            model.addAttribute("fp", ge.consultarUn(id));
        } catch (SQLException ex) {
            Logger.getLogger(controller1.class.getName()).log(Level.SEVERE, null, ex);
            valorfinal="error";
        }
         return valorfinal;
  } 
@PostMapping("/modificar")
  public String modificarBBDD (@ModelAttribute Fp fp, Model model){
        String valorfinal="./fp/listarfp";
        try {
            ge.modificar(fp);
            model.addAttribute("fps",ge.listarFiltrados(""));
        } catch (SQLException ex) {
            Logger.getLogger(controller1.class.getName()).log(Level.SEVERE, null, ex);
            valorfinal="error";
        }
        return valorfinal;
  }
  
}

