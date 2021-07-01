package Grupo11.ProyectoEgg.Entidad;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;

@Entity
@Data
public class Clasificadores implements Serializable{
    @Id
    private Long dni;

    private String nombre;
    private String apellido;
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    private Long edad;
    private String domicilio;
    private String coordenada;
    
    @Column(unique = true)
    private String email;
    
    private String instagram;
    private Long creditos;
    @Temporal(TemporalType.DATE)
    private Date fechaCreacionUsuario;
    private Long telefono;
    private Long puntuacion;
    
    private String clave;

}
