package es.hrc.dermatologia_api.repository;

import es.hrc.dermatologia_api.models.Descripcion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DescripcionRepository extends JpaRepository<Descripcion, Long> {
}