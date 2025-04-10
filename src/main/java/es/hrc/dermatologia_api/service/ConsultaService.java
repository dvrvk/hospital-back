package es.hrc.dermatologia_api.service;

import es.hrc.dermatologia_api.models.*;
import es.hrc.dermatologia_api.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultaService {
    @Autowired
    private ConsultaRepository consultaRepository;

    public List<Consulta> findAll() {
        return consultaRepository.findAll();
    }

    public Optional<Consulta> findById(Long id) {
        return consultaRepository.findById(id);
    }

    public Consulta save(Consulta consulta) {
        return consultaRepository.save(consulta);
    }

    public void deleteById(Long id) {
        consultaRepository.deleteById(id);
    }
}