/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.segurosdb.segurosdb.repositorios;

import com.segurosdb.segurosdb.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author cesar
 */
@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, String>{

@Query("SELECT n FROM Usuario n WHERE n.nombre = :nombre")
public Usuario buscarPorNombre(@Param("nombre") String nombre);
}
