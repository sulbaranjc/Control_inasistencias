
package com.example.controller;

import Codigo.Profesor;
import Codigo.SingletonProfesor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
//@RequestMapping("/base")
public class controller1 {
    
   @GetMapping("/index")
 public String Index(Model model){
     if (SingletonProfesor.isSesion()) {
        model.addAttribute("profesor",SingletonProfesor.getProfesor().getNombre());
        model.addAttribute("prof",SingletonProfesor.getProfesor());
        model.addAttribute("accion","Identificate");
     }else{
        model.addAttribute("profesor"," ");
        model.addAttribute("accion","Identificate");
     }
  return "./index";
  }
  
@GetMapping("/logout")
 public ModelAndView logout(Model model){
        SingletonProfesor.logoutProfesor();
//        model.addAttribute("profesor",SingletonProfesor.getProfesor().getNombre());
//        model.addAttribute("accion","Cerrar Sesión");
        return new ModelAndView("/index", model.asMap());
  }  
 
 


}

