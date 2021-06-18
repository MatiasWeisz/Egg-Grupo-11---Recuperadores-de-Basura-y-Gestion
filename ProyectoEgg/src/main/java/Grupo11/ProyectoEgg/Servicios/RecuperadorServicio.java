/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grupo11.ProyectoEgg.Servicios;

import Grupo11.ProyectoEgg.Entidad.Recuperador;
import Grupo11.ProyectoEgg.Repositorio.RecuperadorRepositorio;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author german
 */
public class RecuperadorServicio {
    @Autowired
    RecuperadorRepositorio recuperadorRepositorio;
    @Transactional
    public void crearRecuperador(Long dni, String nombre, String apellido, String coordenada, Double puntaje, Long telefono, int capacidadMax, int cantidadRutas) {
        Recuperador recuperador = new Recuperador();
        recuperador.setDni(dni);
        recuperador.setNombre(nombre);
        recuperador.setApellido(apellido);
        recuperador.setCoordenada(coordenada);
        recuperador.setPuntaje(puntaje);
        recuperador.setTelefono(telefono);
        recuperador.setCapacidadMax(capacidadMax);
        recuperador.setCantidadRutas(cantidadRutas);
    }
    @Transactional
    public List<Recuperador>buscarTodos(){
        return recuperadorRepositorio.findAll();
    }
}
