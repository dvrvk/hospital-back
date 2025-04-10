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

    // Relación OneToMany con Imagen (1 caso tiene muchas imágenes)
    @OneToMany(mappedBy = "casoClinico", cascade = CascadeType.ALL)
    private List<Imagen> imagenes;

    // Relación OneToOne con Descripcion
    @OneToOne(mappedBy = "casoClinico", cascade = CascadeType.ALL)
    private Descripcion descripcion;

    private String descripcionTexto;
    private String diagnostico;

    private String zona;

    private String fecha;

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

    public List<Imagen> getImagenes() {
        return imagenes;
    }

    public void setImagenes(List<Imagen> imagenes) {
        this.imagenes = imagenes;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(Descripcion descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcionTexto() {
        return descripcionTexto;
    }

    public void setDescripcionTexto(String descripcionTexto) {
        this.descripcionTexto = descripcionTexto;
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
