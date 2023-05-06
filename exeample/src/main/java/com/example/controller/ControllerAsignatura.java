/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.controller;

import Codigo.Asignatura;
import Codigo.Fp;
import Codigo.GestorAsignatura;
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
@RequestMapping("/asignatura")
public class ControllerAsignatura {
    GestorAsignatura ge = new GestorAsignatura ();
    
   @GetMapping("/crud")
 public String crud(Model model){
        String valorfinal="./asignatura/listarasignatura";
        try {
            model.addAttribute("asignaturas", ge.listarFiltrados(""));
        } catch (SQLException ex) {
            Logger.getLogger(controller1.class.getName()).log(Level.SEVERE, null, ex);
            valorfinal="error";
        }
return valorfinal;
  }
    
 @GetMapping("/alta")
  public String greetingForm(Model model) { 
    GestorFp fp = new GestorFp();
    String valorfinal="./asignatura/altaasignatura";
    try {
        model.addAttribute("asignatura", new Asignatura()); 
        model.addAttribute("fps", fp.listarFiltrados(""));
        } catch (SQLException ex) {
            Logger.getLogger(controller1.class.getName()).log(Level.SEVERE, null, ex);
            valorfinal="error";
        }
return valorfinal;
  }
@PostMapping("/alta")
  public String greetingSubmit(@ModelAttribute Asignatura asignatura,@RequestParam("idFp") int idFp, Model model) { 
        String valorfinal="./asignatura/listarasignatura";
        asignatura.setFpId(idFp);
        try {
            ge.alta(asignatura);
            try { 
                model.addAttribute("asignaturas", ge.listarFiltrados(""));
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
        String valorfinal="./asignatura/listarasignatura";
        try {
            model.addAttribute("asignaturas", ge.listar());
        } catch (SQLException ex) {
            Logger.getLogger(controller1.class.getName()).log(Level.SEVERE, null, ex);
            valorfinal="error";
        }
        return valorfinal;
  }  
 @PostMapping("/listar")
 
 public String listarAlumnos(@RequestParam ("filtro") String filtro, Model model){
        String valorfinal="./asignatura/listarasignatura";
        try {
            model.addAttribute("asignaturas", ge.listarFiltrados(filtro));
            model.addAttribute("filtro", filtro);
        } catch (SQLException ex) {
            Logger.getLogger(controller1.class.getName()).log(Level.SEVERE, null, ex);
            valorfinal="error";
        }
        return valorfinal;
  }

  @GetMapping("/eliminar")
  public String SubmitB (@RequestParam ("codasignatura") int id, Model model){
        String valorfinal="./asignatura/listarasignatura";
        try {
            ge.eliminar(id);
             model.addAttribute("asignaturas", ge.listarFiltrados(""));
        } catch (SQLException ex) {
            valorfinal="error";
        }
        return valorfinal;
  } 
@GetMapping("/modificar")
  public String modificar(@RequestParam ("codasignatura") int id,Model model){
        GestorFp fp = new GestorFp();
        String valorfinal="./asignatura/modificarasignatura";
        try {
            model.addAttribute("asignatura", ge.consultarUn(id));
            model.addAttribute("fps", fp.listarFiltrados(""));
            
        } catch (SQLException ex) {
            Logger.getLogger(controller1.class.getName()).log(Level.SEVERE, null, ex);
            valorfinal="error";
        }
         return valorfinal;
  } 
@PostMapping("/modificar")
  public String modificarBBDD (@ModelAttribute Asignatura asignatura,@RequestParam("idFp") int idFp, Model model){
        String valorfinal="./asignatura/listarasignatura";
        asignatura.setFpId(idFp);
        try {
            ge.modificar(asignatura);
            model.addAttribute("asignaturas",ge.listarFiltrados(""));
        } catch (SQLException ex) {
            Logger.getLogger(controller1.class.getName()).log(Level.SEVERE, null, ex);
            valorfinal="error";
        }
        return valorfinal;
  }
  
}

