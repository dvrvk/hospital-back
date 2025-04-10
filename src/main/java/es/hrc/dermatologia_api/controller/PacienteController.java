package es.hrc.dermatologia_api.controller;

import es.hrc.dermatologia_api.DTO.PacienteDTO;
import es.hrc.dermatologia_api.models.Paciente;
import es.hrc.dermatologia_api.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pacientes")
@CrossOrigin(origins = "http://localhost:3000")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    // GET → Obtener todos los pacientes
    @GetMapping
    public List<Paciente> getAllPacientes() {
        return pacienteService.findAll();
    }

    // GET → Obtener un paciente por ID
    @GetMapping("/{id}")
    public Optional<Paciente> getPacienteById(@PathVariable Long id) {
        return pacienteService.findById(id);
    }

    // GET → Buscar paciente por número de historia clínica
    @GetMapping("/buscar")
    public Paciente getPacientePorNumeroHistoria(@RequestParam String numeroHistoria) {
        return pacienteService.findByNumeroHistoria(numeroHistoria);
    }

    // POST → Crear un nuevo paciente
    @PostMapping
    public ResponseEntity<?> createPaciente(@RequestBody PacienteDTO paciente) {
        try {
            Paciente nuevo = pacienteService.save(paciente);
            return ResponseEntity.ok(nuevo);
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body("Ya existe un paciente con ese número de historia.");
        }
    }

    // PUT → Actualizar un paciente existente
    @PutMapping("/{id}")
    public Paciente updatePaciente(@PathVariable Long id, @RequestBody PacienteDTO pacienteActualizado) {
        Optional<Paciente> pacienteExistente = pacienteService.findById(id);
        if (pacienteExistente.isPresent()) {
            Paciente paciente = pacienteExistente.get();
            paciente.setNumeroHistoria(pacienteActualizado.getNumeroHistoria());
            paciente.setGenero(pacienteActualizado.getGenero());
            paciente.setEdad(pacienteActualizado.getEdad());
            return pacienteService.update(paciente);
        } else {
            return null; // o lanzar una excepción personalizada
        }
    }

    // DELETE → Eliminar un paciente por ID
    @DeleteMapping("/{id}")
    public void deletePaciente(@PathVariable Long id) {
        pacienteService.deleteById(id);
    }
}
