package es.hrc.dermatologia_api.repository;

import es.hrc.dermatologia_api.models.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
}