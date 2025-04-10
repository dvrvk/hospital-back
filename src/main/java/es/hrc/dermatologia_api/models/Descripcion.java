package es.hrc.dermatologia_api.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "descripciones")
public class Descripcion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;

    private LocalDateTime fechaDescripcion;

    @OneToOne
    @JoinColumn(name = "id_caso") // FK que apunta a caso_clinico
    private CasoClinico casoClinico;

    // Constructor vacío
    public Descripcion() {}

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDateTime getFechaDescripcion() {
        return fechaDescripcion;
    }

    public void setFechaDescripcion(LocalDateTime fechaDescripcion) {
        this.fechaDescripcion = fechaDescripcion;
    }

    public CasoClinico getCasoClinico() {
        return casoClinico;
    }

    public void setCasoClinico(CasoClinico casoClinico) {
        this.casoClinico = casoClinico;
    }
}
