/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.segurosdb.segurosdb.controladores;

import com.segurosdb.segurosdb.entidades.Compania;
import com.segurosdb.segurosdb.entidades.enums.Riesgo;
import com.segurosdb.segurosdb.excepciones.MiException;
import com.segurosdb.segurosdb.servicios.ClienteServicio;
import com.segurosdb.segurosdb.servicios.CompaniaServicio;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@RequestMapping("/cliente")
public class ClienteControlador {
   
    @Autowired
    private ClienteServicio clienteServicio;
    @Autowired
    private CompaniaServicio companiaServicio;
    
    
    
    @GetMapping("/registrar")
    public String registrar(ModelMap modelo){
        List<Compania> companias = companiaServicio.listarCompania();
//       List<Riesgo> riesgo = riesgoListado
        Riesgo[] riesgos = Riesgo.values();
      modelo.addAttribute("enumRiesgos", riesgos);
       modelo.addAttribute("compania", companias);
        System.out.println("estas son las$$$44444 "+riesgos);
return "cliente_form.html";
}
    
    @PostMapping("/registro")
    public String registro( @RequestParam String nombre,@RequestParam Riesgo riesgo, @RequestParam String patente,
            String idCompania,@RequestParam String poliza, ModelMap modelo){
        try {
             clienteServicio.crearCliente( nombre, riesgo, patente, idCompania, poliza);
             System.out.println("salió"+ nombre);        
              
             modelo.put("exito", "el cliuente fue cargado");
        } catch (MiException ex) {
            modelo.put("error", ex.getMessage());
            System.out.println("no salió");        
            return "cliente_form.html";
            
        }

        return "cliente_form.html";
    }
}
