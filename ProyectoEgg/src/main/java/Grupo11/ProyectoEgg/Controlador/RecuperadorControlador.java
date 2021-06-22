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
@RequestMapping("/Recuperadores")
public class RecuperadorControlador {
    
    @Autowired
    private RecuperadorServicio rs;
    
    @GetMapping
    public ModelAndView mostrarTodos(){
        ModelAndView mav = new ModelAndView("");
        mav.addObject("", rs.buscarTodos());
        return mav;
    }
    
    @GetMapping("/crear")
    public ModelAndView crearRecuperador(){
        ModelAndView mav = new ModelAndView("");
        mav.addObject("", new Recuperador());
        
        return mav;
    }
    
    @GetMapping("/editar/{dni}")
    public ModelAndView editarRecuperador(@PathVariable Long dni) {
        ModelAndView mav = new ModelAndView("");
        mav.addObject("", rs.buscarPorId(dni));
        return mav;
    }
    
    @PostMapping("/guardar")
    public RedirectView guardar (@RequestParam Long dni, @RequestParam String nombre, @RequestParam String apellido,@RequestParam String coordenada, @RequestParam Double puntaje, @RequestParam Long telefono, @RequestParam int capacidadMax, @RequestParam int cantidadRutas){
        rs.crearRecuperador(dni, nombre, apellido, coordenada, puntaje, telefono, capacidadMax, cantidadRutas);
        return new RedirectView("/");
    }
    
    @PostMapping("/modificar")
    public RedirectView modificar (@RequestParam Long dni, @RequestParam String nombre, @RequestParam String apellido,@RequestParam String coordenada, @RequestParam Double puntaje, @RequestParam Long telefono, @RequestParam int capacidadMax, @RequestParam int cantidadRutas){
        rs.modificarRecuperador(dni, nombre, apellido, coordenada, puntaje, telefono, capacidadMax, cantidadRutas);
        return new RedirectView("/");
    }
    
    @PostMapping("/eliminar/{dni}")
    public RedirectView eliminar(@PathVariable Long dni) {
        rs.eliminarRecuperador(dni);
        return new RedirectView("/");
    }
}
