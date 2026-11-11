package com.gremio.controller;

import com.gremio.model.Contacto;
import com.gremio.service.ContactoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

// Este controlador solo habla con el Service, nunca con el Repository
@Controller
public class ContactoController {

    private final ContactoService servicio;

    public ContactoController(ContactoService servicio) {
        this.servicio = servicio;
    }

    // Entrar a http://localhost:8080/ manda a la lista
    @GetMapping("/")
    public String inicio() {
        return "redirect:/contactos";
    }

    // READ: lista de contactos
    @GetMapping("/contactos")
    public String listar(Model model) {
        model.addAttribute("contactos", servicio.listarTodos());
        return "contactos";
    }

    // Formulario vacio (para crear)
    @GetMapping("/nuevo")
    public String formularioNuevo(Model model) {
        model.addAttribute("contacto", new Contacto());
        return "formulario";
    }

    // CREATE
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Contacto contacto) {
        servicio.guardar(contacto);
        return "redirect:/contactos";
    }

    // Formulario con los datos del contacto (para editar). @PathVariable saca el id de la URL
    @GetMapping("/editar/{id}")
    public String formularioEditar(@PathVariable Long id, Model model) {
        model.addAttribute("contacto", servicio.buscarPorId(id));
        return "formulario";
    }

    // UPDATE
    @PostMapping("/actualizar")
    public String actualizar(@ModelAttribute Contacto contacto) {
        servicio.guardar(contacto);
        return "redirect:/contactos";
    }

    // DELETE
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        servicio.eliminar(id);
        return "redirect:/contactos";
    }
}
