package com.example.back_monolito.Dto;

import com.example.back_monolito.Entity.Paciente;

import java.sql.Time;
import java.util.Date;

public class CitaDto {
    private Integer idCita;
    private Integer idTipoCita;
    private Integer idHorario;
    private Integer idPaciente;
    private Integer idAsistente;
    private Time hora;
    private Date fecha;
    private String razon;
    private Boolean estado;

    public CitaDto() {
    }

    public CitaDto(Integer idCita, Integer idTipoCita, Integer idHorario, Integer idPaciente, Integer idAsistente, Time hora, Date fecha, String razon, Boolean estado) {
        this.idCita = idCita;
        this.idTipoCita = idTipoCita;
        this.idHorario = idHorario;
        this.idPaciente = idPaciente;
        this.idAsistente = idAsistente;
        this.hora = hora;
        this.fecha = fecha;
        this.razon = razon;
        this.estado = estado;
    }

    public Integer getIdCita() {
        return idCita;
    }

    public void setIdCita(Integer idCita) {
        this.idCita = idCita;
    }

    public Integer getIdTipoCita() {
        return idTipoCita;
    }

    public void setIdTipoCita(Integer idTipoCita) {
        this.idTipoCita = idTipoCita;
    }

    public Integer getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(Integer idHorario) {
        this.idHorario = idHorario;
    }

    public Integer getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    public Integer getIdAsistente() {
        return idAsistente;
    }

    public void setIdAsistente(Integer idAsistente) {
        this.idAsistente = idAsistente;
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

    public String getRazon() {
        return razon;
    }

    public void setRazon(String razon) {
        this.razon = razon;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "CitaDto{" +
                "idCita=" + idCita +
                ", idTipoCita=" + idTipoCita +
                ", idHorario=" + idHorario +
                ", idPaciente=" + idPaciente +
                ", idAsistente=" + idAsistente +
                ", hora=" + hora +
                ", fecha=" + fecha +
                ", razon='" + razon + '\'' +
                ", estado=" + estado +
                '}';
    }
}
