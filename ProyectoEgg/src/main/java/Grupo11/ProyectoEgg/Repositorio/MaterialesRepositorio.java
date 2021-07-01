/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grupo11.ProyectoEgg.Repositorio;

import Grupo11.ProyectoEgg.Entidad.Materiales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author german
 */
@Repository
public interface MaterialesRepositorio extends JpaRepository<Materiales, Long>{
@Modifying
    @Query("UPDATE Materiales m SET m.carton = :carton, m.plastico = :plastico, m.latas = :latas, m.vidrio = :vidrio, m.papel = :papel WHERE m.id = :id")
    void modificar(@Param("carton") Long carton, @Param("plastico") Long plastico, @Param("latas") Long latas, @Param("vidrio") Long vidrio, @Param("papel") Long papel);


}


