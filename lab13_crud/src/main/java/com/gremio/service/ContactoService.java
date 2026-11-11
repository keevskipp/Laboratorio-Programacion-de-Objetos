package com.gremio.service;

import com.gremio.model.Contacto;
import com.gremio.repository.ContactoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

// Capa Service: queda en medio del Controller y el Repository
@Service
public class ContactoService {

    private final ContactoRepository repositorio;

    public ContactoService(ContactoRepository repositorio) {
        this.repositorio = repositorio;
    }

    // READ: todos los contactos
    public List<Contacto> listarTodos() {
        return repositorio.findAll();
    }

    // CREATE y UPDATE: si el contacto no tiene id hace INSERT, si ya tiene id hace UPDATE
    public Contacto guardar(Contacto contacto) {
        return repositorio.save(contacto);
    }

    // Busca un contacto. Si no existe avisa con una excepcion en vez de regresar null
    public Contacto buscarPorId(Long id) {
        return repositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        "No existe un contacto con el id " + id));
    }

    // DELETE
    public void eliminar(Long id) {
        repositorio.deleteById(id);
    }
}
