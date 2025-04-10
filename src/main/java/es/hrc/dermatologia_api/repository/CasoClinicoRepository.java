package es.hrc.dermatologia_api.repository;

import es.hrc.dermatologia_api.models.CasoClinico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CasoClinicoRepository extends JpaRepository<CasoClinico, Long> {
}