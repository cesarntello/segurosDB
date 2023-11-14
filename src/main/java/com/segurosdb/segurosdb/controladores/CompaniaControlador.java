/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.segurosdb.segurosdb.controladores;

import com.segurosdb.segurosdb.excepciones.MiException;
import com.segurosdb.segurosdb.servicios.CompaniaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author cesar
 */
@Controller
@RequestMapping("/compania")
public class CompaniaControlador {
    @Autowired
    private CompaniaServicio companiaServicio;
    
    @GetMapping("/registrarCompania")
    public String registrar(){
        return "compania_form.html";
    }
    
    @PostMapping("/registroCompania")
    public String registro( @RequestParam String razonSocial, ModelMap modelo){
        try{
            companiaServicio.crearCompania(razonSocial);
            System.out.println("Companioa creada");
            modelo.put("exito", "se cargo con exito");
            
        }catch(MiException ex){
        modelo.put("error", ex.getMessage());
        return "compania_form.html";
        }
    
    return "index.html";
    }        
}
