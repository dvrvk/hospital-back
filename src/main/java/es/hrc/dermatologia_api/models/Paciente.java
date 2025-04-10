package es.hrc.dermatologia_api.models;

import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "pacientes")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero_historia", nullable = false, unique = true)
    private String numeroHistoria;

    @Column(nullable = false)
    private String genero;

    private int edad;

    @JsonManagedReference("paciente-caso")
    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL)
    private List<CasoClinico> casosClinicos;

    // Constructor vacío
    public Paciente() {}

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNumeroHistoria() { return numeroHistoria; }
    public void setNumeroHistoria(String numeroHistoria) { this.numeroHistoria = numeroHistoria; }

    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }

    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }

    public List<CasoClinico> getCasosClinicos() { return casosClinicos; }
    public void setCasosClinicos(List<CasoClinico> casosClinicos) { this.casosClinicos = casosClinicos; }
}
