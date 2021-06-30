package Grupo11.ProyectoEgg.Servicios;

import Grupo11.ProyectoEgg.Entidad.Recuperador;
import Grupo11.ProyectoEgg.Repositorio.RecuperadorRepositorio;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecuperadorServicio {
    @Autowired
    private RecuperadorRepositorio recuperadorRepositorio;


    @Transactional
    public void crearRecuperador (Long dni, String nombre, String apellido, Long telefono, int capacidadMax, int cantidadRutas){
        Recuperador recuperador = new Recuperador();
        recuperador.setDni(dni);
        recuperador.setNombre(nombre);
        recuperador.setApellido(apellido);
        recuperador.setPuntaje(0.0);
        recuperador.setTelefono(telefono);
        recuperador.setCapacidadMax(capacidadMax);
        recuperador.setCantidadRutas(cantidadRutas);
        recuperadorRepositorio.save(recuperador);
    }
    
    @Transactional
    public void modificarRecuperador (Long dni, String nombre, String apellido, Double puntaje, Long telefono, int capacidadMax, int cantidadRutas){
        recuperadorRepositorio.modificar(dni,nombre,apellido,puntaje,telefono,capacidadMax,cantidadRutas);
    }
    
    @Transactional
    public List<Recuperador> buscarTodos(){
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
    
}   
