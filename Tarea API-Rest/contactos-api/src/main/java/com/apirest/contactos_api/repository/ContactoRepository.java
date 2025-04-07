package com.apirest.contactos_api.repository;

import com.apirest.contactos_api.model.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactoRepository extends JpaRepository<Contacto, Long> {
}