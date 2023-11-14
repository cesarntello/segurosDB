/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.segurosdb.segurosdb.repositorios;

import com.segurosdb.segurosdb.entidades.Compania;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author cesar
 */
@Repository
public interface CompaniaRepositorio extends JpaRepository<Compania, String> {
    //    COMPROBAR SI ESTAS QUERYS ESTAN BIEN CON REFERENCIA A LAS MAYUSCULAS
    @Query("SELECT r FROM Compania r WHERE r.razonSocial = :razonSocial")
    public Compania buscarPorRazonSocial (@Param("razonSocial") String razonSocial);
    
    
}
