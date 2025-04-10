package es.hrc.dermatologia_api.controller;

import es.hrc.dermatologia_api.models.*;
import es.hrc.dermatologia_api.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {
    @Autowired
    private ConsultaService consultaService;

    @GetMapping
    public List<Consulta> getAll() {
        return consultaService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Consulta> getById(@PathVariable Long id) {
        return consultaService.findById(id);
    }

    @PostMapping
    public Consulta create(@RequestBody Consulta consulta) {
        return consultaService.save(consulta);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        consultaService.deleteById(id);
    }
}