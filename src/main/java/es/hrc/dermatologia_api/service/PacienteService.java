package es.hrc.dermatologia_api.service;

import es.hrc.dermatologia_api.DTO.PacienteDTO;
import es.hrc.dermatologia_api.models.*;
import es.hrc.dermatologia_api.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {
    @Autowired
    private PacienteRepository pacienteRepository;

    public List<Paciente> findAll() {
        return pacienteRepository.findAll();
    }

    public Optional<Paciente> findById(Long id) {
        return pacienteRepository.findById(id);
    }

    public Paciente save(PacienteDTO paciente) {
        Paciente pacienteEntity = new Paciente();
        pacienteEntity.setEdad(paciente.getEdad());
        pacienteEntity.setNumeroHistoria(paciente.getNumeroHistoria());
        pacienteEntity.setGenero(paciente.getGenero());
        return pacienteRepository.save(pacienteEntity);
    }

    public Paciente update(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    public void deleteById(Long id) {
        pacienteRepository.deleteById(id);
    }

    public Paciente findByNumeroHistoria(String numeroHistoria) {
        return pacienteRepository.findByNumeroHistoria(numeroHistoria);
    }

}
