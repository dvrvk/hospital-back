package es.hrc.dermatologia_api.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "imagenes")
public class Imagen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String url;

    private LocalDateTime fechaImagen;

    // Relación ManyToOne con CasoClinico (muchas imágenes pueden pertenecer a un mismo caso)
    @ManyToOne
    @JoinColumn(name = "id_caso")
    private CasoClinico casoClinico;

    // Constructor vacío
    public Imagen() {}

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    public LocalDateTime getFechaImagen() { return fechaImagen; }
    public void setFechaImagen(LocalDateTime fechaImagen) { this.fechaImagen = fechaImagen; }

    public CasoClinico getCasoClinico() { return casoClinico; }
    public void setCasoClinico(CasoClinico casoClinico) { this.casoClinico = casoClinico; }
}
