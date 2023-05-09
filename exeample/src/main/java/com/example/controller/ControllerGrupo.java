/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.controller;

import Codigo.Grupo;
import Codigo.Fp;
import Codigo.GestorGrupo;
import Codigo.GestorFp;
import Codigo.GestorModalidad;
import Codigo.GestorPeriodo;
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
@RequestMapping("/grupo")
public class ControllerGrupo {
    GestorGrupo ge = new GestorGrupo ();
    GestorFp gfp = new GestorFp();
    GestorPeriodo gperiodo = new GestorPeriodo ();
    GestorTurno gturno = new GestorTurno ();
    GestorModalidad gmodalidad = new GestorModalidad ();
    
   @GetMapping("/crud")
 public String crud(Model model){
        String valorfinal="./grupo/listargrupo";
        try {
            model.addAttribute("grupos", ge.listarFiltrados(""));
        } catch (SQLException ex) {
            Logger.getLogger(ControllerGrupo.class.getName()).log(Level.SEVERE, null, ex);
            valorfinal="error";
        }
return valorfinal;
  }
    
 @GetMapping("/alta")
  public String greetingForm(Model model) { 
    String valorfinal="./grupo/altagrupo";
    try {
        model.addAttribute("grupo", new Grupo()); 
        model.addAttribute("periodos", gperiodo.listarFiltrados(""));
        model.addAttribute("fps", gfp.listarFiltrados(""));
        model.addAttribute("turnos", gturno.listarFiltrados(""));
        model.addAttribute("modalidades", gmodalidad.listarFiltrados(""));
        } catch (SQLException ex) {
            Logger.getLogger(ControllerGrupo.class.getName()).log(Level.SEVERE, null, ex);
            valorfinal="error";
        }
return valorfinal;
  }
@PostMapping("/alta")
  public String greetingSubmit(@ModelAttribute Grupo grupo,
          @RequestParam("idFp") int idFp,
          @RequestParam("idModalidad") int idModalidad, 
          @RequestParam("idTurno") int idTurno, 
          @RequestParam("idPeriodo") int idPeriodo, 
          Model model) { 
      String valorfinal="./grupo/listargrupo";
        grupo.setIdPeriodo(idPeriodo);
        grupo.setIdFp(idFp);
        grupo.setIdTurno(idTurno);
        grupo.setIdModalidad(idModalidad);
        try {
            ge.alta(grupo);
            try { 
                model.addAttribute("grupos", ge.listarFiltrados(""));
//                model.addAttribute("filtro", "");
            } catch (SQLException ex) {
                Logger.getLogger(ControllerGrupo.class.getName()).log(Level.SEVERE, null, ex);
                valorfinal="error";
            }
        } catch (SQLException ex) {
            valorfinal="error";
        }
    return valorfinal; 
  }
@GetMapping("/listar")
 public String listarAlumno(Model model){
        String valorfinal="./grupo/listargrupo";
        try {
            model.addAttribute("grupos", ge.listar());
        } catch (SQLException ex) {
            Logger.getLogger(ControllerGrupo.class.getName()).log(Level.SEVERE, null, ex);
            valorfinal="error";
        }
        return valorfinal;
  }  
 @PostMapping("/listar")
 
 public String listarAlumnos(@RequestParam ("filtro") String filtro, Model model){
        String valorfinal="./grupo/listargrupo";
        try {
            model.addAttribute("grupos", ge.listarFiltrados(filtro));
            model.addAttribute("filtro", filtro);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerGrupo.class.getName()).log(Level.SEVERE, null, ex);
            valorfinal="error";
        }
        return valorfinal;
  }

  @GetMapping("/eliminar")
  public String SubmitB (@RequestParam ("codgrupo") int id, Model model){
        String valorfinal="./grupo/listargrupo";
        try {
            ge.eliminar(id);
             model.addAttribute("grupos", ge.listarFiltrados(""));
        } catch (SQLException ex) {
            valorfinal="error";
        }
        return valorfinal;
  } 
@GetMapping("/modificar")
  public String modificar(@RequestParam ("codgrupo") int id,Model model){
        GestorGrupo gp = new GestorGrupo();
        String valorfinal="./grupo/modificargrupo";
        try {
            model.addAttribute("grupo", gp.consultarUn(id));
            model.addAttribute("periodos", gperiodo.listarFiltrados(""));
            model.addAttribute("fps", gfp.listarFiltrados(""));
            model.addAttribute("turnos", gturno.listarFiltrados(""));
            model.addAttribute("modalidades", gmodalidad.listarFiltrados(""));
        } catch (SQLException ex) {
            Logger.getLogger(ControllerGrupo.class.getName()).log(Level.SEVERE, null, ex);
            valorfinal="error";
        }
         return valorfinal;
  } 
@PostMapping("/modificar")
  public String modificarBBDD (@ModelAttribute Grupo grupo,@RequestParam("idFp") int idFp, Model model){
        String valorfinal="./grupo/listargrupo";
        grupo.setIdFp(idFp);
        try {
            ge.modificar(grupo);
            model.addAttribute("grupos",ge.listarFiltrados(""));
        } catch (SQLException ex) {
            Logger.getLogger(ControllerGrupo.class.getName()).log(Level.SEVERE, null, ex);
            valorfinal="error";
        }
        return valorfinal;
  }
  
}

