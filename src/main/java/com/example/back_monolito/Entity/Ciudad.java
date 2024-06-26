package com.example.back_monolito.Entity;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "CIUDAD")
public class Ciudad implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CIUDAD")
    private Integer idCiudad;

    @Column(name = "ID_DEPARTAMENTO")
    private Integer idDepartamento;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "STATUS")
    private Boolean status;

    public Ciudad() {
    }

    public Ciudad(Integer idCiudad, Integer idDepartamento, String nombre, Boolean status) {
        this.idCiudad = idCiudad;
        this.idDepartamento = idDepartamento;
        this.nombre = nombre;
        this.status = status;
    }

    public Integer getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(Integer idCiudad) {
        this.idCiudad = idCiudad;
    }

    public Integer getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Integer idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Ciudad{" +
                "idCiudad=" + idCiudad +
                ", idDepartamento=" + idDepartamento +
                ", nombre='" + nombre + '\'' +
                ", status=" + status +
                '}';
    }
}

