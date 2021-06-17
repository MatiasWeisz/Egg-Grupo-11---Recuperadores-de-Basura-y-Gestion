package Grupo11.ProyectoEgg.Repositorio;

import Grupo11.ProyectoEgg.Entidad.Recuperador;
import Grupo11.ProyectoEgg.Entidad.Ruta;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RutaRepositorio {
    
    @Query("SELECT r FROM Recuperador r WHERE r.departamento =:departamento")
    List<Ruta> buscarPorDepartamento(@Param("departamento") String departamento);
    
    @Modifying
    @Query("UPDATE Ruta r SET r.id =:id, r.departamento =:departamento, r.fecha =:fecha, r.cantidadClasificadores =:cantidadClasificadores, r.valorRuta =:valorRuta, r.recuperadores =:recuperadores WHERE r.id =:id")
    void modificar(@Param("id") String id,@Param ("departamento") String departamento,@Param("fecha") Date fecha,@Param("cantidadClasificadores") int cantidadClasificadores,@Param ("valorRuta") Double valorRuta,@Param("recuperadores") List<Recuperador> recuperadores);
}
