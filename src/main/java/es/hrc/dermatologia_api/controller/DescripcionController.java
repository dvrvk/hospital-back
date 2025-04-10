package es.hrc.dermatologia_api.controller;

import es.hrc.dermatologia_api.models.*;
import es.hrc.dermatologia_api.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/descripciones")
public class DescripcionController {
    @Autowired
    private DescripcionService descripcionService;

    @GetMapping
    public List<Descripcion> getAll() {
        return descripcionService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Descripcion> getById(@PathVariable Long id) {
        return descripcionService.findById(id);
    }

    @PostMapping
    public Descripcion create(@RequestBody Descripcion descripcion) {
        return descripcionService.save(descripcion);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        descripcionService.deleteById(id);
    }
}