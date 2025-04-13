package es.hrc.dermatologia_api.DTO;

import java.time.LocalDate;

public class CasoClinicoDTO {
    private String zona;
    private String diagnostico;
    private ConsultaDTO consulta;
    private String img;

    // Getters y Setters
    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public ConsultaDTO getConsulta() {
        return consulta;
    }

    public void setConsulta(ConsultaDTO consulta) {
        this.consulta = consulta;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    // Clase interna para la consulta
    public static class ConsultaDTO {
        private LocalDate fechaConsulta;
        private Long pacienteId;
        private Long usuarioId;

        // Getters y Setters
        public LocalDate getFechaConsulta() {
            return fechaConsulta;
        }

        public void setFechaConsulta(LocalDate fechaConsulta) {
            this.fechaConsulta = fechaConsulta;
        }

        public Long getPacienteId() {
            return pacienteId;
        }

        public void setPacienteId(Long pacienteId) {
            this.pacienteId = pacienteId;
        }

        public Long getUsuarioId() {
            return usuarioId;
        }

        public void setUsuarioId(Long usuarioId) {
            this.usuarioId = usuarioId;
        }
    }
}

