package es.hrc.dermatologia_api.service;

import es.hrc.dermatologia_api.models.*;
import es.hrc.dermatologia_api.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CasoClinicoService {
    @Autowired
    private CasoClinicoRepository casoClinicoRepository;

    public List<CasoClinico> findAll() {
        return casoClinicoRepository.findAll();
    }

    public Optional<CasoClinico> findById(Long id) {
        return casoClinicoRepository.findById(id);
    }

    public CasoClinico save(CasoClinico casoClinico) {
        return casoClinicoRepository.save(casoClinico);
    }

    public void deleteById(Long id) {
        casoClinicoRepository.deleteById(id);
    }
}