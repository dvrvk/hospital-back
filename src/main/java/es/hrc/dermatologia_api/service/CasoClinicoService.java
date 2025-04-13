package es.hrc.dermatologia_api.service;

import es.hrc.dermatologia_api.DTO.CasoClinicoDTO;
import es.hrc.dermatologia_api.models.*;
import es.hrc.dermatologia_api.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CasoClinicoService {
    @Autowired
    private CasoClinicoRepository casoClinicoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private ConsultaRepository consultaRepository;
    @Autowired
    private ImagenRepository imagenRepository;

    public List<CasoClinico> findAll() {
        return casoClinicoRepository.findAll();
    }

    public Optional<CasoClinico> findById(Long id) {
        return casoClinicoRepository.findById(id);
    }

    public CasoClinico save(CasoClinicoDTO casoClinico) {
        Usuario user = usuarioRepository.findById(casoClinico.getConsulta().getUsuarioId()).orElseThrow(() -> new RuntimeException("ERROR"));
        Paciente paciente = pacienteRepository.findById(casoClinico.getConsulta().getUsuarioId()).orElseThrow(() -> new RuntimeException("ERROR"));
        // Guardar los datos en la  base de datos
        LocalDateTime ahora = LocalDateTime.now();
        Consulta consulta = consultaRepository.save(new Consulta(ahora, paciente, user));
        CasoClinico caso = casoClinicoRepository.save(new CasoClinico(consulta, casoClinico.getDiagnostico(), casoClinico.getZona()));
        // Guardar la imagen el el servidor
        Imagen imagen = imagenRepository.save(new Imagen(casoClinico.getImg(), ahora));
        // CAMBIAR PARA DEVOLVER EL  CASO CLINICO CORRESPONDIENTE AL QUE HEMOS GUARDADO (O HACES UN DTO O DEVUELVE EL CASO CLINICO)
        return casoClinicoRepository.save(new CasoClinico());
    }

    public void deleteById(Long id) {
        casoClinicoRepository.deleteById(id);
    }
}