package es.hrc.dermatologia_api.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "consultas")
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime fechaConsulta;

    // Relación OneToMany con CasoClinico
    @OneToMany(mappedBy = "consulta", cascade = CascadeType.ALL)
    @JsonManagedReference("consulta-caso") // ✅ AÑADIR ESTO
    private List<CasoClinico> casosClinicos;

    // Constructor vacío
    public Consulta() {}

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getFechaConsulta() {
        return fechaConsulta;
    }

    public void setFechaConsulta(LocalDateTime fechaConsulta) {
        this.fechaConsulta = fechaConsulta;
    }

    public List<CasoClinico> getCasosClinicos() {
        return casosClinicos;
    }

    public void setCasosClinicos(List<CasoClinico> casosClinicos) {
        this.casosClinicos = casosClinicos;
    }
}
