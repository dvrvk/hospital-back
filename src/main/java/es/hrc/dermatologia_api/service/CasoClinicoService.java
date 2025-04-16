package es.hrc.dermatologia_api.service;

import es.hrc.dermatologia_api.DTO.CasoClinicoDTO;
import es.hrc.dermatologia_api.DTO.CasoClinicoResponseDTO;
import es.hrc.dermatologia_api.models.*;
import es.hrc.dermatologia_api.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
    @Value("${file.upload-dir}")
    private String uploadDir;
    @Value("${file.host}")
    private String host;

    public List<CasoClinico> findAll() {
        return casoClinicoRepository.findAll();
    }

    public Optional<CasoClinico> findById(Long id) {
        return casoClinicoRepository.findById(id);
    }

    @Transactional
    public CasoClinicoResponseDTO save(CasoClinicoDTO casoClinico) {
        Usuario user = usuarioRepository.findById(casoClinico.getConsulta().getUsuarioId()).orElseThrow(() -> new RuntimeException("ERROR"));
        Paciente paciente = pacienteRepository.findById(casoClinico.getConsulta().getUsuarioId()).orElseThrow(() -> new RuntimeException("ERROR"));
        // Guardar los datos en la  base de datos
        LocalDateTime ahora = LocalDateTime.now();
        Consulta consulta = consultaRepository.save(new Consulta(ahora, paciente, user));
        CasoClinico caso = casoClinicoRepository.save(new CasoClinico(consulta, casoClinico.getDiagnostico(), casoClinico.getZona()));
        // CAMBIAR PARA DEVOLVER EL  CASO CLINICO CORRESPONDIENTE AL QUE HEMOS GUARDADO (O HACES UN DTO O DEVUELVE EL CASO CLINICO)
        String url = guardarImagen(casoClinico.getImg(), paciente.getId(), ahora, caso);
        // DTO
        return new CasoClinicoResponseDTO(paciente.getNumeroHistoria(), "Caso clinico guardado correctamente");
    }

    public void deleteById(Long id) {
        casoClinicoRepository.deleteById(id);
    }

    private String guardarImagen(String base64Data, Long idPaciente, LocalDateTime ahora, CasoClinico casoClinico) {
        try {
            // Crear carpeta si no existe
            File carpeta = new File(uploadDir);
            if (!carpeta.exists()) {
                carpeta.mkdirs();
            }

            // Remover prefijo base64 si lo tiene
            if (base64Data.contains(",")) {
                base64Data = base64Data.split(",")[1];
            }

            // Decodificar base64
            byte[] imagenBytes = Base64.getDecoder().decode(base64Data);

            // Convertir los bytes a BufferedImage
            InputStream is = new ByteArrayInputStream(imagenBytes);
            BufferedImage imagenOriginal = ImageIO.read(is);

            if (imagenOriginal == null) {
                throw new IllegalArgumentException("No se pudo leer la imagen base64 como imagen válida.");
            }

            // Crear nombre de archivo con extensión .jpg
            String nombreArchivo = UUID.randomUUID() + "_" + idPaciente + ".png";
            File archivoImagen = new File(uploadDir, nombreArchivo);

            // Convertir y guardar como JPG
            boolean resultado = ImageIO.write(imagenOriginal, "png", archivoImagen);
            System.out.println("Resultado de escritura: " + resultado);
            System.out.println("Guardando en: " + archivoImagen.getAbsolutePath());

            // Generar URL pública
            String url = host + uploadDir + nombreArchivo;

            // Guardar en BD
            Imagen imagen = new Imagen();
            imagen.setUrl(url);
            imagen.setFechaImagen(ahora);
            imagen.setCasoClinico(casoClinico);

            imagenRepository.save(imagen);

            return url;

        } catch (Exception e) {
            e.printStackTrace(); // Para debug
            throw new RuntimeException("La imagen no se pudo guardar correctamente");
        }
    }
}