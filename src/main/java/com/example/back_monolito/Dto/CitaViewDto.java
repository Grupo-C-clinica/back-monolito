package com.example.back_monolito.Dto;

import java.sql.Time;
import java.util.Date;

public class CitaViewDto {
    private Integer idCita;
    private Integer idPaciente;
    private String nombrePaciente;
    private String apellidoPPaciente;
    private String apellidoMPaciente;
    private Time hora;
    private Date fecha;
    private Boolean estado;

    public CitaViewDto() {
    }

    public CitaViewDto(Integer idCita, Integer idPaciente, String nombrePaciente, String apellidoPPaciente, String apellidoMPaciente, Time hora, Date fecha, Boolean estado) {
        this.idCita = idCita;
        this.idPaciente = idPaciente;
        this.nombrePaciente = nombrePaciente;
        this.apellidoPPaciente = apellidoPPaciente;
        this.apellidoMPaciente = apellidoMPaciente;
        this.hora = hora;
        this.fecha = fecha;
        this.estado = estado;
    }

    public Integer getIdCita() {
        return idCita;
    }


    public void setIdCita(Integer idCita) {
        this.idCita = idCita;
    }

    public Integer getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public String getApellidoPPaciente() {
        return apellidoPPaciente;
    }

    public void setApellidoPPaciente(String apellidoPPaciente) {
        this.apellidoPPaciente = apellidoPPaciente;
    }

    public String getApellidoMPaciente() {
        return apellidoMPaciente;
    }

    public void setApellidoMPaciente(String apellidoMPaciente) {
        this.apellidoMPaciente = apellidoMPaciente;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "CitaViewDto{" +
                "idCita=" + idCita +
                ", idPaciente=" + idPaciente +
                ", nombrePaciente='" + nombrePaciente + '\'' +
                ", apellidoPPaciente='" + apellidoPPaciente + '\'' +
                ", apellidoMPaciente='" + apellidoMPaciente + '\'' +
                ", hora=" + hora +
                ", fecha=" + fecha +
                ", estado=" + estado +
                '}';
    }
}
