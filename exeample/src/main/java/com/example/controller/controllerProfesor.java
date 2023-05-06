
package com.example.controller;

import Codigo.Profesor;
import Codigo.GestorProfesor;
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

@Controller
@RequestMapping("/profesor")
public class controllerProfesor {
    GestorProfesor ge = new GestorProfesor();
    
   @GetMapping("/crud")
 public String crud(Model model){
        String valorfinal="./Profesor/listarprofesor";
        try {
            model.addAttribute("profesores", ge.listarFiltrados(""));
        } catch (SQLException ex) {
            Logger.getLogger(controllerProfesor.class.getName()).log(Level.SEVERE, null, ex);
            valorfinal="error";
        }
        return valorfinal;
  }
    
 @GetMapping("/alta")
  public String greetingForm(Model model) { 
    model.addAttribute("profesor", new Profesor()); 
  return "./profesor/altaProfesor";
  }
@PostMapping("/alta")
  public String greetingSubmit(@ModelAttribute Profesor profesor, Model model) { 
        String valorfinal="./profesor/listarProfesor";
        try {
            ge.alta(profesor);
            try { 
                model.addAttribute("profesores", ge.listarFiltrados(""));
                model.addAttribute("filtro", "");
            } catch (SQLException ex) {
                Logger.getLogger(controllerProfesor.class.getName()).log(Level.SEVERE, null, ex);
                valorfinal="error";
            }
        } catch (SQLException ex) {
            valorfinal="error";
        }
    return valorfinal; 
  }
@GetMapping("/listar")
 public String listarProfesor(Model model){
        String valorfinal="./profesor/listarProfesor";
        try {
            model.addAttribute("profesores", ge.listarFiltrados(""));
        } catch (SQLException ex) {
            Logger.getLogger(controllerProfesor.class.getName()).log(Level.SEVERE, null, ex);
            valorfinal="error";
        }
        return valorfinal;
  }  
 @PostMapping("/listar")
 
 public String listarProfesor(@RequestParam ("filtro") String filtro, Model model){
        String valorfinal="./profesor/listarProfesor";
        try {
            model.addAttribute("profesores", ge.listarFiltrados(filtro));
            model.addAttribute("filtro", filtro);
        } catch (SQLException ex) {
            Logger.getLogger(controllerProfesor.class.getName()).log(Level.SEVERE, null, ex);
            valorfinal="error";
        }
        return valorfinal;
  }

  @GetMapping("/eliminar")
  public String SubmitB (@RequestParam ("codprofesor") int id, Model model){
        String valorfinal="./profesor/listarProfesor";
        try {
            ge.eliminar(id);
             model.addAttribute("profesores", ge.listarFiltrados(""));
        } catch (SQLException ex) {
            valorfinal="error";
        }
        return valorfinal;
  } 
@GetMapping("/modificar")
  public String modificar(@RequestParam ("codprofesor") int id,Model model){
        String valorfinal="./Profesor/modificarProfesor";
        try {
            model.addAttribute("profesor", ge.consultarUn(id));
        } catch (SQLException ex) {
            Logger.getLogger(controllerProfesor.class.getName()).log(Level.SEVERE, null, ex);
            valorfinal="error";
        }
         return valorfinal;
  } 
@PostMapping("/modificar")
  public String modificarBBDD (@ModelAttribute Profesor profesor, Model model){
        String valorfinal="./Profesor/listarProfesor";
        try {
            ge.modificar(profesor);
            model.addAttribute("profesores",ge.listarFiltrados(""));
        } catch (SQLException ex) {
            Logger.getLogger(controllerProfesor.class.getName()).log(Level.SEVERE, null, ex);
            valorfinal="error";
        }
        return valorfinal;
  }
  
}

