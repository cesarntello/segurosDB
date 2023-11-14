/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.segurosdb.segurosdb.servicios;

import com.segurosdb.segurosdb.entidades.Cliente;
import com.segurosdb.segurosdb.entidades.Compania;
import com.segurosdb.segurosdb.entidades.Usuario;
import com.segurosdb.segurosdb.entidades.enums.Riesgo;
import com.segurosdb.segurosdb.excepciones.MiException;
import com.segurosdb.segurosdb.repositorios.ClienteRepositorio;
import com.segurosdb.segurosdb.repositorios.CompaniaRepositorio;
import com.segurosdb.segurosdb.repositorios.UsuarioRepositorio;
import java.util.ArrayList;
import java.util.Date;
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
public class ClienteServicio {
    
@Autowired
private CompaniaRepositorio companiaRepositorio;
//@Autowired 
//private UsuarioRepositorio usuarioRepositorio;
@Autowired
private ClienteRepositorio clienteRepositorio;
   
@Transactional
public void crearCliente( String nombre, Riesgo riesgo, String patente, String idCompania, String poliza)throws MiException{
       
   
    validar( nombre, riesgo, patente, idCompania, poliza);
//        decidir aca si agregamos el user como atributo
        Compania compania = companiaRepositorio.findById(idCompania).get();
//        Usuario usuario = usuarioRepositorio.findById(idUsuario).get();
        Cliente cliente = new Cliente();
 
        cliente.setNombre(nombre);
        
       
        
        cliente.setRiesgo(riesgo);
        cliente.setPoliza(poliza);
        cliente.setPatente(patente);
        
        cliente.setCompania(compania);
        
        cliente.setAlta(new Date());
        
        clienteRepositorio.save(cliente);
    }
    
    public List<Cliente> listarClientes(){
        List<Cliente> clientes = new ArrayList();
        clientes = clienteRepositorio.findAll();
    return clientes;
    }
    
    public void modificarCliente (String id, String nombre, Riesgo riesgo, String patente, String idCompania, String poliza)throws MiException{
         
        validar( nombre, riesgo, patente, idCompania, poliza);
        Optional<Cliente> respuesta = clienteRepositorio.findById(id);
        Optional<Compania> respuestaCompania = companiaRepositorio.findById(idCompania);
         
        Compania compania = new Compania();
        
        if(respuestaCompania.isPresent()){
             compania = respuestaCompania.get();
        }
        if (respuesta.isPresent()){
            
            Cliente cliente = respuesta.get();
            cliente.setAlta(new Date());
            cliente.setNombre(nombre);
            cliente.setRiesgo(riesgo);
            cliente.setPatente(patente);
            cliente.setPoliza(poliza);
            cliente.setCompania(compania);
            clienteRepositorio.save(cliente);
        }
        
    }
    private void validar ( String nombre, Riesgo riesgo, String patente, String idCompania, String poliza)throws MiException{
     
    if ( nombre == null || nombre.isEmpty()) {
        throw new MiException("el nombre esta vacio o nulo");
        
    }
    if ( riesgo == null ) {
        throw new MiException("el riesgo esta vacio o nulo");
        
    }
    if ( patente == null || patente.isEmpty()) {
        throw new MiException("la pantente esta vacia o nula");
        
    }
    if ( idCompania == null || idCompania.isEmpty()) {
        throw new MiException("la compania esta vacio o nulo");
        
    }
    if ( poliza == null || poliza.isEmpty()) {
        throw new MiException("el poliza esta vacio o nulo");
        
    }
//    if ( alta == null ) {
//        throw new MiException("el alta esta vacio o nulo");
//        
//    }
        
    }
            
}
