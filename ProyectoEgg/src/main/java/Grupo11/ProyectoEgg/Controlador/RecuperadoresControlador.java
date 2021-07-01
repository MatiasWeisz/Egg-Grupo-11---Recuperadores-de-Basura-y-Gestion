package Grupo11.ProyectoEgg.Controlador;

import Grupo11.ProyectoEgg.Entidad.Recuperador;
import Grupo11.ProyectoEgg.Servicios.RecuperadorServicio;
import Grupo11.ProyectoEgg.Servicios.RutaServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

/**
 *
 * @author german
 */
@Controller
@RequestMapping("/recuperadores")
public class RecuperadoresControlador {
    @Autowired
    private RecuperadorServicio rs;
    @Autowired
   // private RutaServicio rs;
    
@GetMapping("/ver-todos")
public ModelAndView mostrarTodos(){
    ModelAndView mav = new ModelAndView("Recuperadores");
    List<Recuperador> recuperadores = rs.buscarTodos();
    mav.addObject("recuperadores",recuperadores);
    return mav;
}
@GetMapping("/crear")
public ModelAndView agregarRecuperador(){
    ModelAndView mav = new ModelAndView("RecuperadoresFormulario");
    mav.addObject("recuperador", new Recuperador());
    mav.addObject("title","Agregar REcuperador");
    mav.addObject("action","guardar");
    return mav;
}
@PostMapping("/guardar")
public RedirectView guardar(@RequestParam Long dni, @RequestParam String nombre, @RequestParam String apellido,@RequestParam String username,@RequestParam String clave,@RequestParam String coordenada, @RequestParam Double puntaje, @RequestParam Long telefono, @RequestParam int capacidadMax, @RequestParam int cantidadRutas){
    rs.crearRecuperador(dni, nombre, apellido,username,clave,coordenada, puntaje, telefono, capacidadMax, cantidadRutas);
    return new RedirectView("/recuperadores/ver-todos");
}
   
    
    @GetMapping("/editar/{dni}")
    public ModelAndView editarRecuperador(@PathVariable Long dni) {
        ModelAndView mav = new ModelAndView("RecuperadorFormulario");
        mav.addObject("recuperador", rs.buscarPorId(dni));
        mav.addObject("title", "Editar Recuperador");
        mav.addObject("action", "modificar");
        return mav;
    }
    
    
    
    @PostMapping("/modificar")
    public RedirectView modificar (@RequestParam Long dni, @RequestParam String nombre, @RequestParam String apellido,@RequestParam String username, @RequestParam String clave,  @RequestParam Double puntaje, @RequestParam Long telefono, @RequestParam int capacidadMax, @RequestParam int cantidadRutas){
        rs.modificarRecuperador(dni, nombre, apellido,username,clave, puntaje, telefono, capacidadMax, cantidadRutas);
        return new RedirectView("/recuperadores");
    }
    
    @PostMapping("/eliminar/{dni}")
    public RedirectView eliminar(@PathVariable Long dni) {
        rs.eliminarRecuperador(dni);
        return new RedirectView("/recuperadores");
    }
}