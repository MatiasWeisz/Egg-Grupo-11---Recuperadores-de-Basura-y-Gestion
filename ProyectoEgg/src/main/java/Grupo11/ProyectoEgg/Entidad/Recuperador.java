package Grupo11.ProyectoEgg.Entidad;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Data;


@Entity
@Data
public class Recuperador implements Serializable {
    
    @Id
    private Long dni;
    
    private String nombre;
    private String apellido;
    private String coordenada;
  
    private Double puntaje;
    private Long telefono;
    private int capacidadMax;
    private int cantidadRutas;
    
    @ManyToOne
    private Ruta ruta;
    
    @OnetoOne
    private List<Comentario> comentario;
    
}