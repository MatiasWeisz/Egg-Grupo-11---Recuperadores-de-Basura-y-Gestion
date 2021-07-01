package Grupo11.ProyectoEgg.Controlador;

import Grupo11.ProyectoEgg.Entidad.Recuperador;
import Grupo11.ProyectoEgg.Entidad.Ruta;
import Grupo11.ProyectoEgg.Servicios.RecuperadorServicio;
import Grupo11.ProyectoEgg.Servicios.RutaServicio;
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
@RequestMapping("/rutas")
public class RutaControlador {

    @Autowired
    private RutaServicio rs;

    @Autowired
    private RecuperadorServicio recuServicio;

    @GetMapping
    public ModelAndView mostrarTodas() {
        ModelAndView mav = new ModelAndView("Rutas");
        mav.addObject("rutas", rs.buscarTodos());
        mav.addObject("recuperadores", recuServicio.buscarTodos());
        return mav;
    }

    @GetMapping("/crear")
    public ModelAndView crearRuta() {
        ModelAndView mav = new ModelAndView("RutaFormulario");
        mav.addObject("rutas", new Ruta());
        mav.addObject("recuperadores", recuServicio.buscarTodos());
        mav.addObject("title", "Crear Ruta");
        mav.addObject("action", "guardar");
        return mav;
    }

    @GetMapping("/editar/{id}")
    public ModelAndView editarRuta(@PathVariable String id) {
        ModelAndView mav = new ModelAndView("RutaFormulario");
        mav.addObject("rutas", rs.buscarPorId(id));
        mav.addObject("recuperadores", recuServicio.buscarTodos());
        mav.addObject("title", "Editar Ruta");
        mav.addObject("action", "modificar");
        return mav;
    }

    @PostMapping("/guardar")
    public RedirectView guardar(@RequestParam String departamento, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date fecha, @RequestParam int cantidadClasificadores, @RequestParam double valorRuta,@RequestParam Recuperador recuperador) {
        rs.crearRuta(departamento, fecha, cantidadClasificadores, valorRuta, recuperador);
        return new RedirectView("/rutas");
    }

    @PostMapping("/modificar")
    public RedirectView modificar(@RequestParam String id, @RequestParam String departamento, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date fecha, @RequestParam int cantidadClasificadores, @RequestParam Double valorRuta, @RequestParam Recuperador recuperador) {
        rs.modifcicarRuta(id, departamento, fecha, cantidadClasificadores, valorRuta, recuperador);
        return new RedirectView("/rutas");
    }

    @PostMapping("/eliminar/{id}")
    public RedirectView eliminar(@PathVariable String id) {
        rs.eliminarRuta(id);
        return new RedirectView("/rutas");
    }
}
