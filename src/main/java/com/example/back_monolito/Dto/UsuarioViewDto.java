package com.example.back_monolito.Dto;

public class UsuarioViewDto {
    private Integer idUser;
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private String telefono;
    private String correo;
    private String username;
    private String rol;

    public UsuarioViewDto() {
    }

    public UsuarioViewDto(Integer idUser, String nombre, String apellidoP, String apellidoM, String telefono, String correo, String username, String rol) {
        this.idUser = idUser;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.telefono = telefono;
        this.correo = correo;
        this.username = username;
        this.rol = rol;
    }
    public Integer getIdUser() { return idUser; }

    public void setIdUser(Integer idUser){ this.idUser = idUser;}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRol() { return rol; }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "UsuarioViewDto{" +
                "idUser='" + idUser + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidoP='" + apellidoP + '\'' +
                ", apellidoM='" + apellidoM + '\'' +
                ", telefono='" + telefono + '\'' +
                ", correo='" + correo + '\'' +
                ", username='" + username + '\'' +
                ", rol='" + rol + '\'' +
                '}';
    }
}

