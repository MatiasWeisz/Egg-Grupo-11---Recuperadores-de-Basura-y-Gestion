package Grupo11.ProyectoEgg.Controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class BienvenidaControlador {
    @GetMapping
    public ModelAndView inicio(){
        return new ModelAndView("Bienvenida");
    }
}