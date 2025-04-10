package es.hrc.dermatologia_api.models;

import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "casos_clinicos")
public class CasoClinico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relación ManyToOne con Consulta
    @ManyToOne
    @JsonBackReference("consulta-caso") // ✅ AÑADIR ESTO
    @JoinColumn(name = "id_consulta")
    private Consulta consulta;

    // Relación OneToMany con Imagen (1 caso tiene muchas imágenes)
    @OneToMany(mappedBy = "casoClinico", cascade = CascadeType.ALL)
    private List<Imagen> imagenes;

    private String diagnostico;

    private String zona;

    // Constructor vacío
    public CasoClinico() {
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    public List<Imagen> getImagenes() {
        return imagenes;
    }

    public void setImagenes(List<Imagen> imagenes) {
        this.imagenes = imagenes;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

}
