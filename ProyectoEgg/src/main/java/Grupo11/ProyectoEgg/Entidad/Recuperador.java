/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grupo11.ProyectoEgg.Entidad;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Data;

/**
 *
 * @author german
 */
@Entity
@Data
public class Recuperador implements Serializable {
    
    @Id
    private long dni;
    private String nombre;
    private String apellido;
    private String username;
    private String clave;
    private String coordenada;
    private Double puntaje;
    private Long telefono;
    private int capacidadMax;
    private int cantidadRutas;
    
   /* @ManyToOne
    private Ruta ruta;
    @ManyToOne
    private List<Comentario> comentario;*/
}