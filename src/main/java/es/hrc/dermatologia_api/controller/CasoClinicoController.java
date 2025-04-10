package es.hrc.dermatologia_api.controller;

import es.hrc.dermatologia_api.models.*;
import es.hrc.dermatologia_api.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/casos")
public class CasoClinicoController {
    @Autowired
    private CasoClinicoService casoClinicoService;

    @GetMapping
    public List<CasoClinico> getAll() {
        return casoClinicoService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<CasoClinico> getById(@PathVariable Long id) {
        return casoClinicoService.findById(id);
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<CasoClinico> create(@RequestBody CasoClinico casoClinico) {
        // AQUI DTO CASOCLINICO -> CONSULTADTO
        CasoClinico nuevo = casoClinicoService.save(casoClinico);
        return ResponseEntity.ok(nuevo);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        casoClinicoService.deleteById(id);
    }
}