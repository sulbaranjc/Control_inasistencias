/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.controller;

import Codigo.Fp;
import Codigo.GestorTipoInasistencia;
import Codigo.TipoInasistencia;
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
@RequestMapping("/tipoinasistencia")

public class ControllerTipoInasistencia {
    GestorTipoInasistencia ge = new GestorTipoInasistencia ();
    
   @GetMapping("/crud")
 public String crud(Model model){
        String valorfinal="./TipoInasistencia/listarTipoInasistencia";
        try {
            model.addAttribute("tipoInasistencias", ge.listarFiltrados(""));
        } catch (SQLException ex) {
            Logger.getLogger(controller1.class.getName()).log(Level.SEVERE, null, ex);
            valorfinal="error";
        }
        return valorfinal;
  }
    
 @GetMapping("/alta")
  public String greetingForm(Model model) { 
    model.addAttribute("tipoInasistencia", new TipoInasistencia()); 
  return "./TipoInasistencia/altaTipoInasistencia";
  }
@PostMapping("/alta")
  public String greetingSubmit(@ModelAttribute TipoInasistencia tipoInasistencia, Model model) { 
        String valorfinal="./TipoInasistencia/listarTipoInasistencia";
        try {
            ge.alta(tipoInasistencia);
            try { 
                model.addAttribute("tipoInasistencias", ge.listarFiltrados(""));
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
        String valorfinal="./TipoInasistencia/listarTipoInasistencia";
        try {
            model.addAttribute("tipoInasistencias", ge.listarFiltrados(""));
        } catch (SQLException ex) {
            Logger.getLogger(controller1.class.getName()).log(Level.SEVERE, null, ex);
            valorfinal="error";
        }
        return valorfinal;
  }  
 @PostMapping("/listar")
 
 public String listarAlumnos(@RequestParam ("filtro") String filtro, Model model){
        String valorfinal="./TipoInasistencia/listarTipoInasistencia";
        try {
            model.addAttribute("tipoInasistencias", ge.listarFiltrados(filtro));
            model.addAttribute("filtro", filtro);
        } catch (SQLException ex) {
            Logger.getLogger(controller1.class.getName()).log(Level.SEVERE, null, ex);
            valorfinal="error";
        }
        return valorfinal;
  }

  @GetMapping("/eliminar")
  public String SubmitB (@RequestParam ("codTi") int id, Model model){
        String valorfinal="./TipoInasistencia/listarTipoInasistencia";
        try {
            ge.eliminar(id);
             model.addAttribute("tipoInasistencias", ge.listarFiltrados(""));
        } catch (SQLException ex) {
            valorfinal="error";
        }
        return valorfinal;
  } 
@GetMapping("/modificar")
  public String modificar(@RequestParam ("codTi") int id,Model model){
        String valorfinal="./TipoInasistencia/modificarTipoInasistencia";
        try {
            model.addAttribute("tipoInasistencia", ge.consultarUn(id));
        } catch (SQLException ex) {
            Logger.getLogger(controller1.class.getName()).log(Level.SEVERE, null, ex);
            valorfinal="error";
        }
         return valorfinal;
  } 
@PostMapping("/modificar")
  public String modificarBBDD (@ModelAttribute TipoInasistencia tipoInasistencia, Model model){
        String valorfinal="./TipoInasistencia/listarTipoInasistencia";
        try {
            ge.modificar(tipoInasistencia);
            model.addAttribute("tipoInasistencias",ge.listarFiltrados(""));
        } catch (SQLException ex) {
            Logger.getLogger(controller1.class.getName()).log(Level.SEVERE, null, ex);
            valorfinal="error";
        }
        return valorfinal;
  }
  
}

