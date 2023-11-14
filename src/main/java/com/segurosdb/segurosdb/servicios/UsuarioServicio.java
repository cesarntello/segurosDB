/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.segurosdb.segurosdb.servicios;

import com.segurosdb.segurosdb.entidades.Cliente;
import com.segurosdb.segurosdb.entidades.Compania;
import com.segurosdb.segurosdb.entidades.Usuario;
import com.segurosdb.segurosdb.repositorios.ClienteRepositorio;
import com.segurosdb.segurosdb.repositorios.UsuarioRepositorio;
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
public class UsuarioServicio {
    
@Autowired
private UsuarioRepositorio usuarioRepositorio;
@Autowired
private ClienteRepositorio clienteRepositorio;
@Transactional
    public void crearUsuario(String id,String nombre, String email, String password){
    
    Usuario usuario = new Usuario();
    
   
    
    usuario.setId(id);
    usuario.setEmail(email);
    usuario.setPassword(password);
  
    usuario.setNombre(nombre);
    usuarioRepositorio.save(usuario);
    
    
        
        
    }

  public List<Usuario> listarUsuarios(){
        List<Usuario> usuarios = new ArrayList();
        usuarios = usuarioRepositorio.findAll();
        return usuarios;
    }
  
  public void modificarUsuario(String id,String nombre, String email, String password, String idCliente){
      
      
      Optional<Usuario> respuesta = usuarioRepositorio.findById(id);
      Optional<Cliente> respuestaCliente = clienteRepositorio.findById(idCliente);
      
      Cliente cliente = new Cliente();
      
      if(respuestaCliente.isPresent()){
          cliente = respuestaCliente.get();
      }
      if(respuesta.isPresent()){
          
          Usuario usuario = new Usuario();
          
          
          usuario.setEmail(email);
          usuario.setNombre(nombre);
          usuario.setPassword(password);
          usuario.setCliente(cliente);
          usuarioRepositorio.save(usuario);
      }
  }
}
