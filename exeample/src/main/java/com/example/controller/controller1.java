
package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
//@RequestMapping("/base")
public class controller1 {
    
   @GetMapping("/index")
 public String Index(Model model){
  return "./index";
  }
  
  
 
 


}

