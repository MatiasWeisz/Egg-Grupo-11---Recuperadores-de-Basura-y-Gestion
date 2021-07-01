package Grupo11.ProyectoEgg.Controlador;

import Grupo11.ProyectoEgg.Servicios.RolesServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/roles")
public class RolesControlador {
    
    @Autowired
    private RolesServicio rolServicio;
    
    @GetMapping("/crear")
    public ModelAndView crearRol(){
        return new ModelAndView("roles-formulario");
    }
    
@PostMapping("/guardar")
public RedirectView guardar(@RequestParam String nombre){
    rolServicio.crear(nombre);
    return new RedirectView("/");
        
}

}
