package com.gremio.controller;

import com.gremio.model.Contacto;
import com.gremio.repository.ContactoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ContactoController {

    private final ContactoRepository repositorio;

    // Spring nos pasa el repositorio solito por el constructor
    public ContactoController(ContactoRepository repositorio) {
        this.repositorio = repositorio;
    }

    // Si entran a http://localhost:8080/ los mandamos a la lista
    @GetMapping("/")
    public String inicio() {
        return "redirect:/contactos";
    }

    // LISTAR: muestra todos los contactos
    @GetMapping("/contactos")
    public String listar(Model model) {
        model.addAttribute("contactos", repositorio.findAll());
        return "contactos";
    }

    // Muestra el formulario vacio para agregar
    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("contacto", new Contacto());
        return "nuevo";
    }

    // GUARDAR: recibe el formulario (POST) y guarda en la base de datos
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Contacto contacto) {
        repositorio.save(contacto);
        return "redirect:/contactos";
    }

    // ---------- Pregunta 4: UPDATE y DELETE ----------

    // Muestra el formulario con los datos del contacto que se quiere editar
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Contacto contacto = repositorio.findById(id).orElse(null);
        if (contacto == null) {
            // si no existe ese id, regresamos a la lista
            return "redirect:/contactos";
        }
        model.addAttribute("contacto", contacto);
        return "editar";
    }

    // UPDATE: como el contacto trae su id, save() lo actualiza en vez de crear uno nuevo
    @PostMapping("/actualizar")
    public String actualizar(@ModelAttribute Contacto contacto) {
        repositorio.save(contacto);
        return "redirect:/contactos";
    }

    // DELETE: borra el contacto con ese id
    @PostMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        repositorio.deleteById(id);
        return "redirect:/contactos";
    }
}
