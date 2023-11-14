/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.segurosdb.segurosdb.servicios;

import com.segurosdb.segurosdb.entidades.Cliente;
import com.segurosdb.segurosdb.entidades.Compania;
import com.segurosdb.segurosdb.excepciones.MiException;
import com.segurosdb.segurosdb.repositorios.ClienteRepositorio;
import com.segurosdb.segurosdb.repositorios.CompaniaRepositorio;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author cesar
 */
@Service
public class CompaniaServicio {
    
//@Autowired
//private ClienteRepositorio clienteRepositorio;
@Autowired
 CompaniaRepositorio companiaRepositorio;
    
@Transactional
public void crearCompania( String razonSocial)throws MiException{
    
       validar(razonSocial);
//    Cliente cliente = clienteRepositorio.findById(idCliente).get();
        
    Compania compania = new Compania();
    
//    compania.setCliente(cliente);
    
    compania.setRazonSocial(razonSocial);
    
    companiaRepositorio.save(compania);
    
    
    }
    
    public List<Compania> listarCompania(){
        List<Compania> companias = new ArrayList();
        companias = companiaRepositorio.findAll();
        return companias;
    }
    
    public void modificarCompania (String id, String razonSocial){
        
        Optional<Compania> respuesta = companiaRepositorio.findById(id);
//        Optional<Cliente> respuestaCliente = clienteRepositorio.findById(idCliente);
//        chequear si hace falta idCliente en esta funcion
       
//        Cliente cliente = new Cliente();
        
//        if(respuestaCliente.isPresent()){
//        cliente = respuestaCliente.get();
//    }
        if(respuesta.isPresent()){
             Compania compania = respuesta.get();
//             compania.setCliente((List<Cliente>) cliente);
             compania.setRazonSocial(razonSocial);
             companiaRepositorio.save(compania);
        }
    }
    private void validar ( String razonSocial)throws MiException{
        
//        if (id == null) {
//            throw new MiException("el id esta vacio");
//            
//        }
        if(razonSocial == null || razonSocial.isEmpty()){
            throw new MiException("la razon social esta vacio");
        }
        
    }
}
