package com.example.back_monolito.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ASISTENTE")
public class Asistente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ASISTENTE")
    private Integer idAsistente;

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "ID_PERSONA", nullable = false)
    private Persona persona;

    @Column(name = "USERNAME", nullable = false)
    private String username;

    @Column(name = "CORREO", nullable = false)
    private String correo;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "STATUS", nullable = false)
    private Boolean status;

    public Asistente() {
    }

    public Asistente(Integer idAsistente, Persona persona, String username, String correo, String password, Boolean status) {
        this.idAsistente = idAsistente;
        this.persona = persona;
        this.username = username;
        this.correo = correo;
        this.password = password;
        this.status = status;
    }

    public Integer getIdAsistente() {
        return idAsistente;
    }

    public void setIdAsistente(Integer idAsistente) {
        this.idAsistente = idAsistente;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Asistente{" +
                "idAsistente=" + idAsistente +
                ", persona=" + persona +
                ", username='" + username + '\'' +
                ", correo='" + correo + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                '}';
    }
}
