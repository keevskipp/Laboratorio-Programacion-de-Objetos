package com.gremio.repository;

import com.gremio.model.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;

// Solo con extender JpaRepository ya se tienen save(), findAll(), findById(), deleteById(), etc.
public interface ContactoRepository extends JpaRepository<Contacto, Long> {
}
