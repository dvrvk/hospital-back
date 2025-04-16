package es.hrc.dermatologia_api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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

    // Relación ManyToOne con Paciente
    @ManyToOne
    @JsonIgnoreProperties({ "casosClinicos" })
    @JoinColumn(name = "id_paciente")
    private Paciente paciente;

    // Relación ManyToOne con Usuario
    @ManyToOne
    @JsonIgnoreProperties({ "casosClinicos" })
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;


    // Constructor vacío
    public Consulta() {}

    public Consulta(LocalDateTime fechaConsulta, Paciente paciente, Usuario usuario) {
        this.fechaConsulta = fechaConsulta;
        this.paciente = paciente;
        this.usuario = usuario;
    }

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


    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
