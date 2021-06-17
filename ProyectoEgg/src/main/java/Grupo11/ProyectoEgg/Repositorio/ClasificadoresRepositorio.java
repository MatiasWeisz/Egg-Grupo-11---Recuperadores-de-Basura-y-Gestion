
package Grupo11.ProyectoEgg.Repositorio;

import Grupo11.ProyectoEgg.Entidad.Clasificadores;
import java.util.Date;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClasificadoresRepositorio extends JpaRepository<Clasificadores,Long> {

    public void modificarClasificadores(String nombre, String apellido, Long edad, String domicilio, String coordenada, String email, String instagram, Long creditos, Long telefono, Long puntuacion, Date fechacreacionusuario);
    
}
