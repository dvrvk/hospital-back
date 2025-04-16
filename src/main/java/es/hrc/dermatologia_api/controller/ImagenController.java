package es.hrc.dermatologia_api.controller;

import es.hrc.dermatologia_api.models.*;
import es.hrc.dermatologia_api.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/imagenes")
public class ImagenController {
    @Autowired
    private ImagenService imagenService;

    @Value("${file.upload-dir}")
    private String uploadDir;

    @GetMapping
    public List<Imagen> getAll() {
        return imagenService.findAll();
    }

    @GetMapping("/{imageName}")
    public ResponseEntity<Resource> getImage(@PathVariable String imageName) throws IOException {
        Path path = Paths.get(uploadDir, imageName);
        if (!Files.exists(path)) {
            return ResponseEntity.notFound().build();
        }

        Resource resource = new UrlResource(path.toUri());
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_PNG)
                .body(resource);
    }

    @PostMapping
    public Imagen create(@RequestBody Imagen imagen) {
        return imagenService.save(imagen);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        imagenService.deleteById(id);
    }
}