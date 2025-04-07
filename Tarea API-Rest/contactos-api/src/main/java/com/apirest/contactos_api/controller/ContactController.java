package com.apirest.contactos_api.controller;

import com.apirest.contactos_api.model.Contacto;
import com.apirest.contactos_api.repository.ContactoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/contactos")
public class ContactController {

    @Autowired
    private ContactoRepository repo;

    @GetMapping
    public List<Contacto> getAll() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contacto> getById(@PathVariable Long id) {
        Optional<Contacto> contacto = repo.findById(id);
        return contacto.map(ResponseEntity::ok)
                       .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Contacto create(@RequestBody Contacto contacto) {
        return repo.save(contacto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contacto> update(@PathVariable Long id, @RequestBody Contacto detalles) {
        return repo.findById(id).map(contacto -> {
            contacto.setNombre(detalles.getNombre());
            contacto.setEmail(detalles.getEmail());
            contacto.setTelefono(detalles.getTelefono());
            return ResponseEntity.ok(repo.save(contacto));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
