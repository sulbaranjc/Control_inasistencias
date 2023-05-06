
package com.example.controller;

import Codigo.Alumno;
import Codigo.GestorAlumno;
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
@RequestMapping("/alumno")
public class controllerAlumno {
    GestorAlumno ge = new GestorAlumno ();
    
   @GetMapping("/crud")
 public String crud(Model model){
        String valorfinal="./Alumno/listarAlumno";
        try {
            model.addAttribute("alumnos", ge.listarFiltrados(""));
        } catch (SQLException ex) {
            Logger.getLogger(controllerAlumno.class.getName()).log(Level.SEVERE, null, ex);
            valorfinal="error";
        }
        return valorfinal;
  }
    
 @GetMapping("/alta")
  public String greetingForm(Model model) { 
    model.addAttribute("alumno", new Alumno()); 
  return "./alumno/altaAlumno";
  }
@PostMapping("/alta")
  public String greetingSubmit(@ModelAttribute Alumno alumno, Model model) { 
        String valorfinal="./Alumno/listarAlumno";
        try {
            ge.alta(alumno);
            try { 
                model.addAttribute("alumnos", ge.listarFiltrados(""));
                model.addAttribute("filtro", "");
            } catch (SQLException ex) {
                Logger.getLogger(controllerAlumno.class.getName()).log(Level.SEVERE, null, ex);
                valorfinal="error";
            }
        } catch (SQLException ex) {
            valorfinal="error";
        }
    return valorfinal; 
  }
@GetMapping("/listar")
 public String listarAlumno(Model model){
        String valorfinal="./Alumno/listarAlumno";
        try {
            model.addAttribute("alumnos", ge.listarFiltrados(""));
        } catch (SQLException ex) {
            Logger.getLogger(controllerAlumno.class.getName()).log(Level.SEVERE, null, ex);
            valorfinal="error";
        }
        return valorfinal;
  }  
 @PostMapping("/listar")
 
 public String listarAlumnos(@RequestParam ("filtro") String filtro, Model model){
        String valorfinal="./Alumno/listarAlumno";
        try {
            model.addAttribute("alumnos", ge.listarFiltrados(filtro));
            model.addAttribute("filtro", filtro);
        } catch (SQLException ex) {
            Logger.getLogger(controllerAlumno.class.getName()).log(Level.SEVERE, null, ex);
            valorfinal="error";
        }
        return valorfinal;
  }

  @GetMapping("/eliminar")
  public String SubmitB (@RequestParam ("codalumno") int id, Model model){
        String valorfinal="./Alumno/listarAlumno";
        try {
            ge.eliminar(id);
             model.addAttribute("alumnos", ge.listarFiltrados(""));
        } catch (SQLException ex) {
            valorfinal="error";
        }
        return valorfinal;
  } 
@GetMapping("/modificar")
  public String modificar(@RequestParam ("codalumno") int id,Model model){
        String valorfinal="./Alumno/modificarAlumno";
        try {
            model.addAttribute("alumno", ge.consultarUn(id));
        } catch (SQLException ex) {
            Logger.getLogger(controllerAlumno.class.getName()).log(Level.SEVERE, null, ex);
            valorfinal="error";
        }
         return valorfinal;
  } 
@PostMapping("/modificar")
  public String modificarBBDD (@ModelAttribute Alumno alumno, Model model){
        String valorfinal="./Alumno/listarAlumno";
        try {
            ge.modificar(alumno);
            model.addAttribute("alumnos",ge.listarFiltrados(""));
        } catch (SQLException ex) {
            Logger.getLogger(controllerAlumno.class.getName()).log(Level.SEVERE, null, ex);
            valorfinal="error";
        }
        return valorfinal;
  }
  
}

