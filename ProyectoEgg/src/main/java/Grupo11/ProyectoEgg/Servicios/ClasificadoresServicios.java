package Grupo11.ProyectoEgg.Servicios;

import Grupo11.ProyectoEgg.Entidad.Clasificadores;
import Grupo11.ProyectoEgg.Repositorio.ClasificadoresRepositorio;
import Grupo11.ProyectoEgg.Validaciones.Validaciones;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClasificadoresServicios implements UserDetailsService {

    @Autowired
    private Validaciones validaciones;

    @Autowired
    private ClasificadoresRepositorio clasificadoresRepositorio;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Transactional
    public void crearClasificador(String nombre, String apellido, Date FechaNacimiento, Long edad, Long dni, String domicilio,
            String coordenada, String email, String instagram, Long creditos, Long telefono,
            Long puntuacion, Date fechaCreacionUsuario, String clave) {

        Clasificadores clasificadores = new Clasificadores();

        clasificadores.setNombre(nombre);
        clasificadores.setApellido(apellido);
        clasificadores.setFechaNacimiento(FechaNacimiento);
        clasificadores.setEdad(edad);
        clasificadores.setDni(dni);
        clasificadores.setDomicilio(domicilio);
        clasificadores.setCoordenada(coordenada);

//        do {
//           
//            if (validaciones.validarEmail(email) == true) {
//                System.out.println("EL EMAIL SE CREO CORRECTAMENTE");
//                clasificadores.setEmail(email);
//            }
//        } while (!validaciones.validarEmail(email) == true);

        clasificadores.setEmail(email);
        clasificadores.setInstagram(instagram);
        clasificadores.setCreditos(creditos);
        clasificadores.setTelefono(telefono);
        clasificadores.setPuntuacion(puntuacion);
        clasificadores.setFechaCreacionUsuario(fechaCreacionUsuario);
        clasificadores.setClave(encoder.encode(clave));

        clasificadoresRepositorio.save(clasificadores);

    }

    @Transactional
    public void modificarClasificadores(String nombre, String apellido, Date FechaNacimiento, Long edad, Long dni, String domicilio,
            String coordenada, String email, String instagram, Long creditos, Long telefono,
            Long puntuacion, Date fechaCreacionUsuario, String clave) {

        clasificadoresRepositorio.modificarClasificadores(nombre, apellido, FechaNacimiento, edad, domicilio, coordenada, email, instagram,
                creditos, fechaCreacionUsuario, telefono, puntuacion, dni, clave);

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

    @Transactional(readOnly = true)
    public List<Clasificadores> buscarTodos() {
        return clasificadoresRepositorio.findAll();
    }

    @Transactional(readOnly = true)
    public List<Clasificadores> buscarPorNombre(String nombre) {
        return clasificadoresRepositorio.buscarPorNombre(nombre);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Clasificadores clasificadores = clasificadoresRepositorio.buscarPorEmail(email);

        if (clasificadores == null) {
            throw new UsernameNotFoundException("No hay un usuario con email " + email);
        }

        User user = new User(clasificadores.getEmail(), clasificadores.getClave(), Collections.emptyList());

        return user;
    }

}
