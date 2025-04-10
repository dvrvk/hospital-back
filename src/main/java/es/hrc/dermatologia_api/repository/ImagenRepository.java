package es.hrc.dermatologia_api.repository;

import es.hrc.dermatologia_api.models.Imagen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImagenRepository extends JpaRepository<Imagen, Long> {
}