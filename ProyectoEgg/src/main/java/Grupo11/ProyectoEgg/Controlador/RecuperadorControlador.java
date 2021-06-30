/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grupo11.ProyectoEgg.Controlador;

import Grupo11.ProyectoEgg.Entidad.Recuperador;
import Grupo11.ProyectoEgg.Servicios.RecuperadorServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
public class RecuperadorControlador {
    @Autowired
    private RecuperadorServicio recuperadorServicio;
    
@GetMapping("/ver-todos")
public ModelAndView mostrarTodos(){
    ModelAndView mav = new ModelAndView("lista-recuperadores");
    List<Recuperador> recuperadores = recuperadorServicio.buscarTodos();
    mav.addObject("recuperadores",recuperadores);
    return mav;
}
@GetMapping("/crear")
public ModelAndView agregarRecuperador(){
    ModelAndView mav = new ModelAndView("carga-recuperadores");
    mav.addObject("recuperador", new Recuperador());
    mav.addObject("title","Agregar Clasificador");
    mav.addObject("action","guardar");
    return mav;
}
@PostMapping("/guardar")
public RedirectView guardar(@RequestParam Long dni, @RequestParam String nombre, @RequestParam String apellido,@RequestParam String username,@RequestParam String clave,@RequestParam String coordenada, @RequestParam Double puntaje, @RequestParam Long telefono, @RequestParam int capacidadMax, @RequestParam int cantidadRutas){
    recuperadorServicio.crear(dni, nombre, apellido,username,clave,coordenada, puntaje, telefono, capacidadMax, cantidadRutas);
    return new RedirectView("/recuperadores/ver-todos");
}
}
