/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.segurosdb.segurosdb.repositorios;

import com.segurosdb.segurosdb.entidades.Cliente;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author cesar
 */
@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, String >{
    
//    COMPROBAR SI ESTAS QUERYS ESTAN BIEN CON REFERENCIA A LAS MAYUSCULAS
    @Query("SELECT n FROM Cliente n WHERE n.nombre = :nombre")
    public Cliente buscarPorNombre(@Param("nombre")String nombre);
    
    @Query("SELECT p FROM Cliente p WHERE p.poliza = :poliza")
    public List<Cliente> buscarPorPoliza(@Param("poliza") String poliza);
}
