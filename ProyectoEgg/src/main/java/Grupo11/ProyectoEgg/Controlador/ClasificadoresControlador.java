package Grupo11.ProyectoEgg.Controlador;

import Grupo11.ProyectoEgg.Entidad.Clasificadores;
import Grupo11.ProyectoEgg.Servicios.ClasificadoresServicio;
import Grupo11.ProyectoEgg.Servicios.ClasificadoresServicio;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/clasificadores")
public class ClasificadoresControlador {

    @Autowired
    private ClasificadoresServicio clasificadoresServicio;

    @GetMapping("/crear")
    public ModelAndView crearClasificador() {
        ModelAndView mav = new ModelAndView("clasificador-formulario");
        mav.addObject("clasificador", new Clasificadores());
        mav.addObject("title", "Crear Clasificadores");
        mav.addObject("action", "guardar");
        return mav;
    }
    @PostMapping("/guardar")
    public RedirectView guardar(@RequestParam String nombre, @RequestParam String apellido, 
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaNacimiento, @RequestParam Long dni, 
            @RequestParam Long edad, @RequestParam String domicilio,@RequestParam String coordenada, @RequestParam String email, 
            @RequestParam String instagram, @RequestParam Long creditos,@RequestParam Long telefono, @RequestParam Long puntuacion, 
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechacreacionusuario) {
        clasificadoresServicio.crearClasificador(nombre, apellido, edad, edad, domicilio, coordenada, email, instagram, creditos, 
                telefono, puntuacion, fechacreacionusuario);
        return new RedirectView("/clasificadores");
}
    @GetMapping("/editar/{dni}")
    public ModelAndView editarClasificador(@PathVariable Long dni) {
        ModelAndView mav = new ModelAndView("clasificador-formulario");
        mav.addObject("clasificador", clasificadoresServicio.buscarPorId(dni));
        mav.addObject("title", "Editar Clasificador");
        mav.addObject("action", "modificar");
        return mav;
    }

    @PostMapping("/modificar")
    public RedirectView modificarClasificadores(@RequestParam Long dni, @RequestParam String nombre, @RequestParam String apellido, 
            @RequestParam Long edad, @RequestParam String domicilio, @RequestParam String coordenada, @RequestParam String email, 
            @RequestParam String instagram, @RequestParam Long creditos, @RequestParam Long telefono, @RequestParam Long puntuacion, 
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechacreacionusuario) {
        clasificadoresServicio.modificarClasificadores(nombre, apellido, edad, domicilio, coordenada, email, instagram, creditos, telefono,
                puntuacion, fechacreacionusuario);
        return new RedirectView("/clasificadores");
    }

    @PostMapping("/eliminar/{dni}")
    public RedirectView eliminarClasificadores(@PathVariable Long dni) {
        clasificadoresServicio.eliminarClasificadores(dni);
        return new RedirectView("/clasificadores");
    }
}
