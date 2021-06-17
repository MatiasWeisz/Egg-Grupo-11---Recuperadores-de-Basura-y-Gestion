
package Grupo11.ProyectoEgg.Servicios;

import Grupo11.ProyectoEgg.Entidad.Recuperador;
import Grupo11.ProyectoEgg.Entidad.Ruta;
import Grupo11.ProyectoEgg.Entidad.Ruta_;
import java.util.Date;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class RutaServicio {
    @Transactional
    public void crearRuta (String departamento, Date fecha, int cantidadClasificadores, Double valorRuta, List<Recuperador> recuperadores){
        Ruta ruta = new Ruta();
        ruta.setDepartamento(departamento);
        ruta.setFecha(fecha);
        ruta.setCantidadClasificadores(cantidadClasificadores);
        ruta.setValorRuta(valorRuta);
        ruta.setRecuperador(recuperadores);
    }
}
