package Grupo11.ProyectoEgg.Servicios;

import Grupo11.ProyectoEgg.Entidad.Recuperador;
import Grupo11.ProyectoEgg.Repositorio.RecuperadorRepositorio;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
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
    public void crearRecuperador(Long dni, String nombre, String apellido, String username, String clave, String coordenada, Double puntaje, Long telefono, int capacidadMax, int cantidadRutas) {
        Recuperador recuperador = new Recuperador();
        recuperador.setDni(dni);
        recuperador.setNombre(nombre);
        recuperador.setApellido(apellido);
        recuperador.setUsername(username);
        recuperador.setClave(encoder.encode(clave));
        recuperador.setPuntaje(0.0);
        recuperador.setTelefono(telefono);
        recuperador.setCapacidadMax(capacidadMax);
        recuperador.setCantidadRutas(cantidadRutas);
        recuperadorRepositorio.save(recuperador);
    }
    @Transactional
    public void modificarRecuperador (Long dni, String nombre, String apellido, String username, String clave, Double puntaje, Long telefono, int capacidadMax, int cantidadRutas){
        recuperadorRepositorio.modificar(dni,nombre,apellido,username,clave,puntaje,telefono,capacidadMax,cantidadRutas);
    }
    @Transactional
    public List<Recuperador>buscarTodos(){
        return recuperadorRepositorio.findAll();
    }
    @Transactional
    public List<Recuperador> buscarporNombre(String nombre){
        return recuperadorRepositorio.buscarPorNombre(nombre);
    }
    @Transactional
    public Recuperador buscarPorId(Long dni){
        Optional<Recuperador> recuperadorOpcional = recuperadorRepositorio.findById(dni);
        return recuperadorOpcional.orElse(null);
    }
    @Transactional
    public void eliminarRecuperador (Long dni){
        recuperadorRepositorio.deleteById(dni);
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