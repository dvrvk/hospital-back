package es.hrc.dermatologia_api.repository;

import es.hrc.dermatologia_api.models.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    Paciente findByNumeroHistoria(String numeroHistoria);

}