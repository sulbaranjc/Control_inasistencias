/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.controller;

import Codigo.Asignatura;
import Codigo.GestorAsignatura;
import Codigo.GestorProfesor;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author sulbaranjc
 */
@Controller
@RequestMapping("/asistencia")

public class ControllerAsistencia {
   GestorProfesor ge = new GestorProfesor(); 
   GestorAsignatura geAsg = new GestorAsignatura ();
   @GetMapping("/crud")
 public String crud(Model model)
 {
    String valorfinal="./asistencia/asistencia";
       try {
           model.addAttribute("profesores", ge.listarFiltrados(""));
       } catch (SQLException ex) {
           Logger.getLogger(ControllerAsistencia.class.getName()).log(Level.SEVERE, null, ex);
           valorfinal="error";
       }
    return valorfinal;
 }
@GetMapping("/{idProfesor}")
@ResponseBody
public List<Asignatura> getAsignaturasPorProfesor(@PathVariable int idProfesor) {
    // Aquí se asume que tiene una lista de asignaturas por profesor almacenada en algún lugar
    // y que puede filtrarla para obtener las asignaturas del profesor seleccionado
    List<Asignatura> asignaturas = null  ;
       try {
           asignaturas = geAsg.getAsignaturasPorProfesor(1);
       } catch (SQLException ex) {
           Logger.getLogger(ControllerAsistencia.class.getName()).log(Level.SEVERE, null, ex);
       }
    return asignaturas;
} 
    

}
