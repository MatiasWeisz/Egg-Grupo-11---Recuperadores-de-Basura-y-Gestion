package Grupo11.ProyectoEgg.Repositorio;

import Grupo11.ProyectoEgg.Entidad.Recuperador;
import java.util.Date;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RutaRepositorio {
    
    @Query("SELECT r FROM Recuperador r WHERE r.departamento =:departamento")
    
    
    @Modifying
    @Query ("UPDATE Ruta r SET r.id =:id, r.departamento =:departamento, r.fecha =:fecha, r.cantidadClasificadores =:cantidadClasificadores, r.valorRuta =:valorRuta, r.Recuperador recuperador")
    void modificar(@Param("id") String id,@Param ("departamento") String departamento,@Param("fecha") Date fecha,@Param("cantidadClasificadores") int cantidadClasificadores,@Param ("valorRuta") Double valorRuta,@Param("recuperador") Recuperador recuperador);
}
