package es.hrc.dermatologia_api.service;

import es.hrc.dermatologia_api.DTO.UsuarioDTO;
import es.hrc.dermatologia_api.models.*;
import es.hrc.dermatologia_api.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> findById(Long id) {
        return usuarioRepository.findById(id);
    }

    public Usuario save(UsuarioDTO usuario) {
        Usuario user = new Usuario();
        user.setNombre(usuario.getNombre());
        user.setApellidos(usuario.getApellidos());
        user.setEmail(usuario.getEmail());
        user.setPassword(usuario.getPassword());
        return usuarioRepository.save(user);
    }

    public void deleteById(Long id) {
        usuarioRepository.deleteById(id);
    }

    public Usuario login(String email, String password) {
        return usuarioRepository.findByEmailAndPassword(email, password)
                .orElseThrow(() -> new RuntimeException("Credenciales inválidas"));
    }
}