package Grupo11.ProyectoEgg.Controlador;

import Grupo11.ProyectoEgg.Entidad.Recuperador;
import Grupo11.ProyectoEgg.Servicios.RecuperadorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/recuperadores")
public class RecuperadorControlador {
    
    @Autowired
    private RecuperadorServicio rs;
    
    @GetMapping
    public ModelAndView mostrarTodos(){
        ModelAndView mav = new ModelAndView("Recuperadores");
        mav.addObject("recuperadores", rs.buscarTodos());
        return mav;
    }
    
    @GetMapping("/crear")
    public ModelAndView crearRecuperador(){
        ModelAndView mav = new ModelAndView("RecuperadorFormulario");
        mav.addObject("recuperador", new Recuperador());
        mav.addObject("title", "Crear Recuperador");
        mav.addObject("action", "guardar");
        return mav;
    }
    
    @GetMapping("/editar/{dni}")
    public ModelAndView editarRecuperador(@PathVariable Long dni) {
        ModelAndView mav = new ModelAndView("RecuperadorFormulario");
        mav.addObject("recuperador", rs.buscarPorId(dni));
        mav.addObject("title", "Editar Recuperador");
        mav.addObject("action", "modificar");
        return mav;
    }
    
    @PostMapping("/guardar")
    public RedirectView guardar (@RequestParam Long dni, @RequestParam String nombre, @RequestParam String apellido, @RequestParam Long telefono, @RequestParam int capacidadMax, @RequestParam int cantidadRutas){
        rs.crearRecuperador(dni, nombre, apellido, telefono, capacidadMax, cantidadRutas);
        return new RedirectView("/recuperadores");
    }
    
    @PostMapping("/modificar")
    public RedirectView modificar (@RequestParam Long dni, @RequestParam String nombre, @RequestParam String apellido, @RequestParam Double puntaje, @RequestParam Long telefono, @RequestParam int capacidadMax, @RequestParam int cantidadRutas){
        rs.modificarRecuperador(dni, nombre, apellido, puntaje, telefono, capacidadMax, cantidadRutas);
        return new RedirectView("/recuperadores");
    }
    
    @PostMapping("/eliminar/{dni}")
    public RedirectView eliminar(@PathVariable Long dni) {
        rs.eliminarRecuperador(dni);
        return new RedirectView("/recuperadores");
    }
}
