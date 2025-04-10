package es.hrc.dermatologia_api.DTO;

public class UsuarioLoginDTO {
    private String email;
    private String password;

    // Getters y setters
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
