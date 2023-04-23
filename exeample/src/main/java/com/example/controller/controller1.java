
package com.example.controller;

import Codigo.Cliente;
import Codigo.gestorCliente;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
//@RequestMapping("/base")
public class controller1 {
    gestorCliente ge = new gestorCliente ();
    
   @GetMapping("/index")
 public String Index(Model model){
//     model.addAttribute("clientes", ge.listarClientes()); 
  return "index";
  }
    
    @GetMapping("/alta")
  public String greetingForm(Model model) { 
    model.addAttribute("cliente", new Cliente()); 
  return "./Clientes/altaCliente";
  }
  
  @PostMapping("/alta")
  public String greetingSubmit(@ModelAttribute Cliente cliente, Model model) { 
        String valorfinal="./Clientes/listarCliente";
        try {
            ge.altaCliente(cliente);
            try { 
                model.addAttribute("clientes", ge.listarClientes());
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
 public String listarClientes(Model model){
        String valorfinal="./Clientes/listarCliente";
        try {
            model.addAttribute("clientes", ge.listarClientesFiltrados(""));
        } catch (SQLException ex) {
            Logger.getLogger(controller1.class.getName()).log(Level.SEVERE, null, ex);
            valorfinal="error";
        }
        return valorfinal;
  }
 
 @PostMapping("/listar")
 public String listarClientesBBDD(@RequestParam ("filtro") String filtro, Model model){
        System.out.println("el filtro es : "+filtro);
        String valorfinal="./Clientes/listarCliente";
        try {
            model.addAttribute("clientes", ge.listarClientesFiltrados(filtro));
            model.addAttribute("filtro", filtro);
        } catch (SQLException ex) {
            Logger.getLogger(controller1.class.getName()).log(Level.SEVERE, null, ex);
            valorfinal="error";
        }
        return valorfinal;
  }
 
 @GetMapping("/eliminar")
  public String SubmitB (@RequestParam ("codcliente") int id, Model model){
      String valorfinal="./Clientes/listarCliente";
        try {
            ge.eliminarCliente(id);
             model.addAttribute("clientes", ge.listarClientes());
        } catch (SQLException ex) {
            valorfinal="error";
        }
        return valorfinal;
  } 
  
  @GetMapping("/modificar")
  public String modificarCliente (@RequestParam ("codcliente") int id,Model model){
        String valorfinal="./Clientes/modificarcliente";
        try {
            model.addAttribute("cliente", ge.consultarUnCliente(id));
        } catch (SQLException ex) {
            Logger.getLogger(controller1.class.getName()).log(Level.SEVERE, null, ex);
            valorfinal="error";
        }
         return valorfinal;
  }

   @PostMapping("/modificar")
  public String modificarClienteBBDD (@ModelAttribute Cliente cliente, Model model){
        String valorfinal="./Clientes/listarCliente";
        try {
            ge.modificarCliente(cliente);
            model.addAttribute("clientes", ge.listarClientes());
        } catch (SQLException ex) {
            Logger.getLogger(controller1.class.getName()).log(Level.SEVERE, null, ex);
            valorfinal="error";
        }
        return valorfinal;
  }

}

