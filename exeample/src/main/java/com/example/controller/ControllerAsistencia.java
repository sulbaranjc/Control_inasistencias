/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author sulbaranjc
 */
@Controller
@RequestMapping("/asistencia")

public class ControllerAsistencia {
    
   @GetMapping("/crud")
 public String crud(Model model){
        String valorfinal="./asistencia/asistencia";
return valorfinal;
  }
    

}
