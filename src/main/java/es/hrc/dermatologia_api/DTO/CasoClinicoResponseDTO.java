package es.hrc.dermatologia_api.DTO;

import lombok.Data;


public class CasoClinicoResponseDTO {
    private String numHistoriaPaciente;
    private String mensaje;

    public CasoClinicoResponseDTO(String numHistoriaPaciente, String mensaje) {
        this.numHistoriaPaciente = numHistoriaPaciente;
        this.mensaje = mensaje;
    }

    public String getNumHistoriaPaciente() {
        return numHistoriaPaciente;
    }

    public void setNumHistoriaPaciente(String numHistoriaPaciente) {
        this.numHistoriaPaciente = numHistoriaPaciente;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
