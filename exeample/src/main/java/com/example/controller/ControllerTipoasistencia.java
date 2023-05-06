/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.controller;

import Codigo.GestorTipoAsistencia;
import Codigo.TipoAsistencia;
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
@RequestMapping("/tipoasistencia")

public class ControllerTipoasistencia {
    GestorTipoAsistencia ge = new GestorTipoAsistencia ();
    
   @GetMapping("/crud")
 public String crud(Model model){
        String valorfinal="./Tipoasistencia/listarTipoasistencia";
        try {
            model.addAttribute("tipoasistencias", ge.listarFiltrados(""));
        } catch (SQLException ex) {
            Logger.getLogger(ControllerTipoasistencia.class.getName()).log(Level.SEVERE, null, ex);
            valorfinal="error";
        }
        return valorfinal;
  }
    
 @GetMapping("/alta")
  public String greetingForm(Model model) { 
    model.addAttribute("tipoasistencia", new TipoAsistencia()); 
  return "./Tipoasistencia/altaTipoasistencia";
  }
@PostMapping("/alta")
  public String greetingSubmit(@ModelAttribute TipoAsistencia tipoasistencia, Model model) { 
        String valorfinal="./Tipoasistencia/listarTipoasistencia";
        try {
            ge.alta(tipoasistencia);
            try { 
                model.addAttribute("tipoasistencias", ge.listarFiltrados(""));
                model.addAttribute("filtro", "");
            } catch (SQLException ex) {
                Logger.getLogger(ControllerTipoasistencia.class.getName()).log(Level.SEVERE, null, ex);
                valorfinal="error";
            }
        } catch (SQLException ex) {
            valorfinal="error";
        }
    return valorfinal; 
  }
@GetMapping("/listar")
 public String listarTipoasistencia(Model model){
        String valorfinal="./Tipoasistencia/listarTipoasistencia";
        try {
            model.addAttribute("tipoasistencias", ge.listarFiltrados(""));
        } catch (SQLException ex) {
            Logger.getLogger(ControllerTipoasistencia.class.getName()).log(Level.SEVERE, null, ex);
            valorfinal="error";
        }
        return valorfinal;
  }  
 @PostMapping("/listar")
 
 public String listarTipoasistenciaFiltro(@RequestParam ("filtro") String filtro, Model model){
        String valorfinal="./Tipoasistencia/listarTipoasistencia";
        try {
            model.addAttribute("tipoasistencias", ge.listarFiltrados(filtro));
            model.addAttribute("filtro", filtro);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerTipoasistencia.class.getName()).log(Level.SEVERE, null, ex);
            valorfinal="error";
        }
        return valorfinal;
  }

  @GetMapping("/eliminar")
  public String SubmitB (@RequestParam ("codTi") int id, Model model){
        String valorfinal="./Tipoasistencia/listarTipoasistencia";
        try {
            ge.eliminar(id);
             model.addAttribute("tipoasistencias", ge.listarFiltrados(""));
        } catch (SQLException ex) {
            valorfinal="error";
        }
        return valorfinal;
  } 
@GetMapping("/modificar")
  public String modificar(@RequestParam ("codTi") int id,Model model){
        String valorfinal="./Tipoasistencia/modificarTipoasistencia";
        try {
            model.addAttribute("tipoasistencia", ge.consultarUn(id));
        } catch (SQLException ex) {
            Logger.getLogger(ControllerTipoasistencia.class.getName()).log(Level.SEVERE, null, ex);
            valorfinal="error";
        }
         return valorfinal;
  } 
@PostMapping("/modificar")
  public String modificarBBDD (@ModelAttribute TipoAsistencia tipoasistencia, Model model){
        String valorfinal="./Tipoasistencia/listarTipoasistencia";
        try {
            ge.modificar(tipoasistencia);
            model.addAttribute("tipoasistencias",ge.listarFiltrados(""));
        } catch (SQLException ex) {
            Logger.getLogger(ControllerTipoasistencia.class.getName()).log(Level.SEVERE, null, ex);
            valorfinal="error";
        }
        return valorfinal;
  }
  
}

