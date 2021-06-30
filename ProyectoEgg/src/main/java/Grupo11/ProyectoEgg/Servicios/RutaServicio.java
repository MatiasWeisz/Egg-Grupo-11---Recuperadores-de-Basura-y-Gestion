package Grupo11.ProyectoEgg.Servicios;

import Grupo11.ProyectoEgg.Entidad.Recuperador;
import Grupo11.ProyectoEgg.Entidad.Ruta;
import Grupo11.ProyectoEgg.Repositorio.RecuperadorRepositorio;
import Grupo11.ProyectoEgg.Repositorio.RutaRepositorio;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RutaServicio {

    @Autowired
    private RutaRepositorio rutaRepositorio;

    @Autowired
    private RecuperadorRepositorio recuperadorRepositorio;

    @Transactional
    public void crearRuta(String departamento, Date fecha, int cantidadClasificadores, Double valorRuta, List<Recuperador> recuperadores) {
        Ruta ruta = new Ruta();
        ruta.setDepartamento(departamento);
        ruta.setFecha(fecha);
        ruta.setCantidadClasificadores(cantidadClasificadores);
        ruta.setValorRuta(valorRuta);
        ruta.setRecuperadores(recuperadores);

        rutaRepositorio.save(ruta);
    }

    @Transactional
    public void modifcicarRuta(String id, String departamento, Date fecha, int cantidadClasificadores, Double valorRuta, List<Recuperador> recuperadores) {
        
        
        // rutaRepositorio.modificar(id, departamento, fecha, cantidadClasificadores, valorRuta, recuperadores);

//        Ruta rutaOpcional = rutaRepositorio.findById(id).get();
//        rutaOpcional.setDepartamento(departamento);
//        rutaOpcional.setFecha(fecha);
//        rutaOpcional.setCantidadClasificadores(cantidadClasificadores);
//        rutaOpcional.setValorRuta(valorRuta);
//        rutaOpcional.setRecuperadores(recuperadores);
//        rutaRepositorio.save(rutaOpcional);
//        
//        for (Recuperador recuperador : recuperadores) {
//            rutaOpcional.setRecuperadores(null);
//            
//        }
    

    }

    @Transactional
    public List<Ruta> buscarPorDepartamento(String departamento) {
        return rutaRepositorio.buscarPorDepartamento(departamento);
    }

    @Transactional
    public List<Ruta> buscarTodos() {
        return rutaRepositorio.findAll();
    }

    @Transactional
    public Ruta buscarPorId(String id) {
        Optional<Ruta> rutaOpcional = rutaRepositorio.findById(id);
        return rutaOpcional.orElse(null);
    }

    @Transactional
    public void eliminarRuta(String id) {
        rutaRepositorio.deleteById(id);
    }

}
