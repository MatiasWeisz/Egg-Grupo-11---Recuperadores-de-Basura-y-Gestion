package Grupo11.ProyectoEgg.Controlador;

import Grupo11.ProyectoEgg.Entidad.Clasificadores;
import Grupo11.ProyectoEgg.Servicios.ClasificadoresServicios;
import java.util.Date;
import java.util.List;
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
    private ClasificadoresServicios clasificadoresServicios;
    
    @GetMapping("/ver-todos")
    public ModelAndView buscarTodos() {
        ModelAndView mav = new ModelAndView("clasificadores-lista");
        List<Clasificadores> clasificadores = clasificadoresServicios.buscarTodos();
        mav.addObject("clasificadores", clasificadores);
        mav.addObject("title", "Ver Todos");
        return mav;
    }

    @GetMapping("/crear")
    public ModelAndView crearClasificador() {
        ModelAndView mav = new ModelAndView("clasificadores-formulario");
        mav.addObject("clasificador", new Clasificadores());
        mav.addObject("title", "Crear Clasificadores");
        mav.addObject("action", "guardar");
        return mav;
    }

    @PostMapping("/guardar")
    public RedirectView guardar(@RequestParam Long dni, @RequestParam String nombre, @RequestParam String apellido, 
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaNacimiento, @RequestParam Long edad, @RequestParam String domicilio, 
            @RequestParam String coordenada, @RequestParam String email, @RequestParam String instagram, 
            @RequestParam Long creditos, @RequestParam Long telefono, @RequestParam Long puntuacion, 
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaCreacionUsuario, @RequestParam String clave) {
        clasificadoresServicios.crearClasificador(nombre, apellido, fechaNacimiento, edad, dni, domicilio, coordenada, 
                email, instagram, creditos, telefono, puntuacion, fechaCreacionUsuario, clave);
        return new RedirectView("/clasificadores/ver-todos");
}
    
    @GetMapping("/buscar/{nombre}")
    public ModelAndView mostrarPorNombre(@PathVariable String nombre) {
        ModelAndView mav = new ModelAndView("clasificadores-lista");
        mav.addObject("clasificadores", clasificadoresServicios.buscarPorNombre(nombre));
        return mav;
    }

    @GetMapping("/editar/{dni}") //
    public ModelAndView editarClasificador(@PathVariable Long dni) {
        ModelAndView mav = new ModelAndView("clasificadores-formulario");
        mav.addObject("clasificador", clasificadoresServicios.buscarPorId(dni));
        mav.addObject("title", "Editar Clasificador");
        mav.addObject("action", "modificar");
        return mav;
    }

    @PostMapping("/modificar")
    public RedirectView modificarClasificadores(@RequestParam Long dni, @RequestParam String nombre, @RequestParam String apellido, 
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaNacimiento, @RequestParam Long edad, @RequestParam String domicilio, 
            @RequestParam String coordenada, @RequestParam String email, @RequestParam String instagram, 
            @RequestParam Long creditos, @RequestParam Long telefono, @RequestParam Long puntuacion, 
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaCreacionUsuario, @RequestParam String clave) {
        clasificadoresServicios.modificarClasificadores(nombre, apellido, fechaNacimiento, edad, dni, domicilio, coordenada, 
                email, instagram, creditos, telefono, puntuacion, fechaCreacionUsuario, clave);
        return new RedirectView("/clasificadores/ver-todos");
    }

    @PostMapping("/eliminar/{dni}")
    public RedirectView eliminarClasificadores(@PathVariable Long dni) {
        clasificadoresServicios.eliminarClasificadores(dni);
        return new RedirectView("/clasificadores/ver-todos");
    }
}

