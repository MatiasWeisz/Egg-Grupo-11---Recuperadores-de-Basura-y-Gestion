package Grupo11.ProyectoEgg.Servicios;

import Grupo11.ProyectoEgg.Entidad.Roles;
import Grupo11.ProyectoEgg.Repositorio.RolesRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service

public class RolesServicio {
    
    @Autowired
    private RolesRepositorio rolesRepositorio;
    
    
    @Transactional
    public void crear(String nombre){
        
        Roles rol = new Roles();
        rol.setNombre(nombre);
        rolesRepositorio.save(rol);
        
        
    }
    

}

