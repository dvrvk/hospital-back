package es.hrc.dermatologia_api.service;

import es.hrc.dermatologia_api.models.*;
import es.hrc.dermatologia_api.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DescripcionService {
    @Autowired
    private DescripcionRepository descripcionRepository;

    public List<Descripcion> findAll() {
        return descripcionRepository.findAll();
    }

    public Optional<Descripcion> findById(Long id) {
        return descripcionRepository.findById(id);
    }

    public Descripcion save(Descripcion descripcion) {
        return descripcionRepository.save(descripcion);
    }

    public void deleteById(Long id) {
        descripcionRepository.deleteById(id);
    }
}