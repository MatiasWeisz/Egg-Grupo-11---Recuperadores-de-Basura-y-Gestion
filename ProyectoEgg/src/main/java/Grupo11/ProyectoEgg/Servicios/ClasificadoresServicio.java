package Grupo11.ProyectoEgg.Servicios;

import Grupo11.ProyectoEgg.Entidad.Clasificadores;
import Grupo11.ProyectoEgg.Repositorio.ClasificadoresRepositorio;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClasificadoresServicio {

    @Autowired
    private ClasificadoresRepositorio clasificadoresRepositorio;

    @Transactional
    public void crearClasificador(String nombre, String apellido, Long edad, Long dni, String domicilio,
            String coordenada, String email, String instagram, Long creditos, Long telefono,
            Long puntuacion, Date fechacreacionusuario) {

        Clasificadores clasificadores = new Clasificadores();

        clasificadores.setNombre(nombre);
        clasificadores.setApellido(apellido);
        clasificadores.setEdad(edad);
        clasificadores.setDni(edad);
        clasificadores.setDomicilio(domicilio);
        clasificadores.setCoordenada(coordenada);
        clasificadores.setEmail(email);
        clasificadores.setInstagram(instagram);
        clasificadores.setCreditos(creditos);
        clasificadores.setTelefono(telefono);
        clasificadores.setPuntuacion(puntuacion);
        clasificadores.setFechacreacionusuario(fechacreacionusuario);

        clasificadoresRepositorio.save(clasificadores);

    }

    @Transactional
    public void modificarClasificadores(String nombre, String apellido, Long edad, String domicilio,
            String coordenada, String email, String instagram, Long creditos, Long telefono,
            Long puntuacion, Date fechacreacionusuario) {

        clasificadoresRepositorio.modificarClasificadores(nombre, apellido, edad, domicilio,
                coordenada, email, instagram, creditos, telefono,
                puntuacion, fechacreacionusuario);
    }

    @Transactional
    public void eliminarClasificadores(Long dni) {
        clasificadoresRepositorio.deleteById(dni);
    }

    @Transactional
    public Clasificadores buscarPorId(Long dni) {
        Optional<Clasificadores> clasificadoresOpcional = clasificadoresRepositorio.findById(dni);
        return clasificadoresOpcional.orElse(null);
    }

    @Transactional//(readOnly=true)
    public List<Clasificadores> buscarTodos() {
        return clasificadoresRepositorio.findAll();
    }

}