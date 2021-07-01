package Grupo11.ProyectoEgg.Entidad;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import lombok.Data;


@Entity
@Data
public class Recuperador implements Serializable {
    
    @Id
    private Long dni;
    
    private String nombre;
    private String apellido;
    private String username;
    private String clave;
    private Double puntaje;
    private Long telefono;
    private int capacidadMax;
    private int cantidadRutas;
    
    @OneToOne
    private Ruta rutas;
    
//    @OnetoOne
//    private List<Comentario> comentario;
//    
}