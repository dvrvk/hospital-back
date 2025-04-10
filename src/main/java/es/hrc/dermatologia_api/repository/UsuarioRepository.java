package es.hrc.dermatologia_api.repository;

import es.hrc.dermatologia_api.models.Usuario;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmailAndPassword(String email, String password);
}