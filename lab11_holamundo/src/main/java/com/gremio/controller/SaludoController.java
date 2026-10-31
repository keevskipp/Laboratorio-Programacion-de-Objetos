package com.gremio.controller;

import com.gremio.model.Aventurero;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

// Esta clase es el "Controller" del MVC: recibe la peticion del navegador
@Controller
public class SaludoController {

    // Cuando alguien entra a http://localhost:8080/saludo se ejecuta este metodo
    @GetMapping("/saludo")
    public String saludo(Model model) {
        model.addAttribute("mensaje", "¡Hola Mundo desde Spring Boot!");
        model.addAttribute("gremio", "Gran Gremio de Aventureros");
        model.addAttribute("nivel", 1);
        return "saludo";   // busca templates/saludo.html
    }

    // Parte 6: http://localhost:8080/aventurero
    @GetMapping("/aventurero")
    public String aventurero(Model model) {
        Aventurero sylva = new Aventurero("Sylva", "Druida", 10);
        model.addAttribute("aventurero", sylva);
        return "aventurero";   // busca templates/aventurero.html
    }
}
