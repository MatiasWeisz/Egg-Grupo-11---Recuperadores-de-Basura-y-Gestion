package Grupo11.ProyectoEgg.Repositorio;

import Grupo11.ProyectoEgg.Entidad.Recuperador;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RecuperadorRepositorio extends JpaRepository <Recuperador,Long>{
    
    @Query("SELECT r FROM Recuperador r WHERE r.nombre =:nombre")
    List<Recuperador> buscarPorNombre(@Param("nombre") String nombre);
    
    @Modifying
    @Query ("UPDATE Recuperador r SET r.nombre = :nombre, r.apellido =:apellido, r.puntaje =:puntaje, r.telefono =:telefono, r.capacidadMax =:capacidadMax, r.cantidadRutas =:cantidadRutas WHERE r.dni =:dni")
    void modificar (@Param("dni") Long dni,@Param("nombre") String nombre,@Param("apellido") String apellido, @Param("puntaje")Double puntaje, @Param("telefono") Long telefono, @Param("capacidadMax") int capacidadMax, @Param("cantidadRutas")int cantidadRutas );
}
