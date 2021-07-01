package Grupo11.ProyectoEgg.Entidad;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;


@Entity
@Data
public class Ruta implements Serializable {
    
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String departamento;
    
   
   @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    private int cantidadClasificadores;
    private Double valorRuta;
    
    @ToString.Exclude
    @OneToOne
    private Recuperador recuperador;
    
    //Este ultimo es para crear la lista de direcciones para generar la ruta
    //private List <Clasificadores> listaClasificadores;
}
    
    
    //Departamento, Horario, Fecha,
//    Cantidad de clasificadores, 
//            Valor estimado de la ruta,
//                    Recuperador, 
//    Lista de coordenadas (Ruta).
//}
