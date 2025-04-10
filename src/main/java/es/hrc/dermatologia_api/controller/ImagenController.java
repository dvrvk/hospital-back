package es.hrc.dermatologia_api.controller;

import es.hrc.dermatologia_api.models.*;
import es.hrc.dermatologia_api.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/imagenes")
public class ImagenController {
    @Autowired
    private ImagenService imagenService;

    @GetMapping
    public List<Imagen> getAll() {
        return imagenService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Imagen> getById(@PathVariable Long id) {
        return imagenService.findById(id);
    }

    @PostMapping
    public Imagen create(@RequestBody Imagen imagen) {
        return imagenService.save(imagen);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        imagenService.deleteById(id);
    }
}