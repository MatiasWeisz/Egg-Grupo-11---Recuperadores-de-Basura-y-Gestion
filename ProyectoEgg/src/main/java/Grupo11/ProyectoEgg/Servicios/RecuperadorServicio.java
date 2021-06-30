/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grupo11.ProyectoEgg.Servicios;

import Grupo11.ProyectoEgg.Entidad.Recuperador;
import Grupo11.ProyectoEgg.Repositorio.RecuperadorRepositorio;
import java.util.Collections;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author german
 */
@Service
public class RecuperadorServicio implements UserDetailsService {
    @Autowired
    RecuperadorRepositorio recuperadorRepositorio;
    @Autowired
    private BCryptPasswordEncoder encoder;
    @Transactional
    public void crear(Long dni, String nombre, String apellido, String username, String clave, String coordenada, Double puntaje, Long telefono, int capacidadMax, int cantidadRutas) {
        Recuperador recuperador = new Recuperador();
        recuperador.setDni(dni);
        recuperador.setNombre(nombre);
        recuperador.setApellido(apellido);
        recuperador.setUsername(username);
        recuperador.setClave(encoder.encode(clave));
        recuperador.setCoordenada(coordenada);
        recuperador.setPuntaje(puntaje);
        recuperador.setTelefono(telefono);
        recuperador.setCapacidadMax(capacidadMax);
        recuperador.setCantidadRutas(cantidadRutas);
        recuperadorRepositorio.save(recuperador);
    }
    @Transactional
    public List<Recuperador>buscarTodos(){
        return recuperadorRepositorio.findAll();
    }
    @Override
    public UserDetails loadUserByUsername(String username) {
        Recuperador recuperador = recuperadorRepositorio.buscarPorNombreDeUsuario(username);
        if (recuperador == null){
            throw new UsernameNotFoundException("No existe ese username");
        }
        
        return new User(recuperador.getUsername(), recuperador.getClave(), Collections.emptyList());
    }
}
