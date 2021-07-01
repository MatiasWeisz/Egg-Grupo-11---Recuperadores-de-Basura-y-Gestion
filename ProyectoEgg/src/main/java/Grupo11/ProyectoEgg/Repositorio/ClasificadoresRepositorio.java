package Grupo11.ProyectoEgg.Repositorio;

import Grupo11.ProyectoEgg.Entidad.Clasificadores;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClasificadoresRepositorio extends JpaRepository<Clasificadores, Long> {

@Modifying
@Query("UPDATE Clasificadores c SET c.nombre = :nombre, c.apellido = :apellido, c.fechaNacimiento = :fechaNacimiento,"
        + " c.edad = :edad, c.domicilio = :domicilio, c.coordenada = :coordenada, c.email = :email, c.instagram = :instagram,"
        + " c.creditos = :creditos, c.fechaCreacionUsuario = :fechaCreacionUsuario, c.telefono = :telefono,"
        + " c.puntuacion = :puntuacion, c.clave = :clave WHERE c.dni = :dni")
void modificarClasificadores(@Param ("nombre") String nombre, @Param ("apellido") String apellido, 
        @Param ("fechaNacimiento") Date fechanacimiento, @Param ("edad") Long edad, @Param ("domicilio") String domicilio, 
        @Param ("coordenada") String coordenada, @Param ("email") String email, @Param("instagram") String instagram, 
        @Param("creditos") Long creditos, @Param("fechaCreacionUsuario") Date fechaCreacionUsuario, @Param("telefono") Long telefono, 
        @Param("puntuacion") Long puntuacion, @Param("dni") Long dni, @Param("clave") String clave);

@Query("SELECT c FROM Clasificadores c WHERE c.nombre = :nombre")
List<Clasificadores> buscarPorNombre(@Param("nombre") String nombre);

@Query("SELECT c FROM Clasificadores c WHERE c.email = :email")
Clasificadores buscarPorEmail(@Param("email") String email);

}
