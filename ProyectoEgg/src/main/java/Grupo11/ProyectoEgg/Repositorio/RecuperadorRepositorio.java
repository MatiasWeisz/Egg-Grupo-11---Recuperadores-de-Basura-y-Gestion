/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grupo11.ProyectoEgg.Repositorio;

import Grupo11.ProyectoEgg.Entidad.Recuperador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author german
 */
@Repository
public interface RecuperadorRepositorio extends JpaRepository<Recuperador, Long>{
}


