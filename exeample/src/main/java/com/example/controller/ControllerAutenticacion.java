/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.controller;

import Codigo.GestorProfesor;
import Codigo.Profesor;
import Codigo.SingletonProfesor;
import java.sql.SQLException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author sulbaranjc
 */
@Controller
@RequestMapping("/autenticacion")
public class ControllerAutenticacion {
   private GestorProfesor gestorProfesor = SingletonProfesor.getGestorProfesor();
//   GestorProfesor ge = new GestorProfesor (); 
   
 @GetMapping("/login")
 public String login(Model model){
        String valorfinal="./autenticacion/login";
        if (SingletonProfesor.isSesion()) {
            SingletonProfesor.logoutProfesor();
        }
        model.addAttribute("profesor", new Profesor()); 
        return valorfinal;
  }
    
@PostMapping("/login")
public ModelAndView greetingSubmit(@ModelAttribute Profesor buscarProfesor, Model model)
    {
        try {
            Profesor profesor = gestorProfesor.autenticarProfesor(buscarProfesor);
            if (profesor != null) {
                    SingletonProfesor.setProfesor(profesor);
                    model.addAttribute("profesor",SingletonProfesor.getProfesor());
                    System.out.println("sesion valida para : "+SingletonProfesor.getProfesor().getNombre());
                    return new ModelAndView("redirect:/index");
            } else {
                model.addAttribute("error", "Credenciales inválidas. Por favor, inténtalo de nuevo.");
                System.out.println("erros en sesion");
                return new ModelAndView("autenticacion/login", model.asMap());
            }
        } catch (SQLException e) {
            // Manejo del error de base de datos
            model.addAttribute("error", "Error en la base de datos. Por favor, inténtalo de nuevo más tarde.");
            return new ModelAndView("redirect:/autenticacion/login");
        }
    }    
@GetMapping("/logout")
 public ModelAndView logout(Model model){
        SingletonProfesor.logoutProfesor();
//        model.addAttribute("profesor",SingletonProfesor.getProfesor().getNombre());
//        model.addAttribute("accion","Cerrar Sesión");
        return new ModelAndView("redirect:/index");
  }
     
}
