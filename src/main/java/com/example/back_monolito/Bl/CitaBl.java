package com.example.back_monolito.Bl;


import com.example.back_monolito.Dao.CitaRepository;
import com.example.back_monolito.Dto.CitaDto;
import com.example.back_monolito.Dto.CitaViewDto;
import com.example.back_monolito.Entity.Cita;
import com.example.back_monolito.Entity.Horario;
import com.example.back_monolito.Entity.Paciente;
import com.example.back_monolito.Entity.TipoCita;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CitaBl {

    @Autowired
    private CitaRepository citaRepository;

    //Crear cita par aun paciente
    public void createCita(CitaDto citaDto, Integer idAsistente){
        TipoCita tipoCita = new TipoCita();
        Horario horario = new Horario();
        Paciente paciente = new Paciente();
        Cita cita = new Cita();
        tipoCita.setIdTipoCita(citaDto.getIdTipoCita());
        horario.setIdHorario(citaDto.getIdHorario());
        paciente.setIdPaciente(citaDto.getIdPaciente());
        cita.setTipoCita(tipoCita);
        cita.setHorario(horario);
        cita.setIdPaciente(paciente);
        cita.setIdAsistente(idAsistente);
        cita.setFecha(citaDto.getFecha());
        cita.setHora(citaDto.getHora());
        cita.setRazon(citaDto.getRazon());
        cita.setStatus(true);
        citaRepository.save(cita);
        System.out.println("Hora: " + citaDto.getHora());
    }

    //Ver todas las citas de un paciente por su fecha
    public List<CitaDto> findAllByPatientIdAndDate(Integer patientId, Date fechaCita){
        List<Cita> cita = citaRepository.findAllByPatientId(patientId, fechaCita);
        List<CitaDto> citaDto = new ArrayList<>();
        for (Cita citas : cita){
            CitaDto citaDtos = new CitaDto();
            citaDtos.setIdCita(citas.getIdCita());
            citaDtos.setIdTipoCita(citas.getTipoCita().getIdTipoCita());
            citaDtos.setIdHorario(citas.getHorario().getIdHorario());
            citaDtos.setIdPaciente(citas.getIdPaciente().getIdPaciente());
            citaDtos.setIdAsistente(citas.getIdAsistente());
            citaDtos.setFecha(citas.getFecha());
            citaDtos.setHora(citas.getHora());
            citaDtos.setRazon(citas.getRazon());
            citaDtos.setEstado(citas.getStatus());
            citaDto.add(citaDtos);
        }
        return citaDto;
    }

    public List<CitaDto> findAllByDateRange (Date fechaInicio, Date fechaFin){
        List<Cita> cita = citaRepository.findAllBetweenDates(fechaInicio, fechaFin);
        List<CitaDto> citaDto = new ArrayList<>();
        for (Cita citas: cita){
            CitaDto citaDtos = new CitaDto();
            citaDtos.setIdCita(citas.getIdCita());
            citaDtos.setIdTipoCita(citas.getTipoCita().getIdTipoCita());
            citaDtos.setIdHorario(citas.getHorario().getIdHorario());
            citaDtos.setIdPaciente(citas.getIdPaciente().getIdPaciente());
            citaDtos.setIdAsistente(citas.getIdAsistente());
            citaDtos.setFecha(citas.getFecha());
            citaDtos.setHora(citas.getHora());
            citaDtos.setRazon(citas.getRazon());
            citaDtos.setEstado(citas.getStatus());
            citaDto.add(citaDtos);
        }
        return citaDto;
    }

    public List<CitaViewDto> findAllByDate (Date fecha){
        List<Cita> cita = citaRepository.findAllCitasByFecha(fecha);
        List<CitaViewDto> citaDto = new ArrayList<>();
        for(Cita citas: cita){
            CitaViewDto citaDtos = new CitaViewDto();
            citaDtos.setIdCita(citas.getIdCita());
            citaDtos.setIdPaciente(citas.getIdPaciente().getIdPaciente());
            citaDtos.setNombrePaciente(citas.getIdPaciente().getPersona().getNombre());
            citaDtos.setApellidoPPaciente(citas.getIdPaciente().getPersona().getApellidoP());
            citaDtos.setApellidoMPaciente(citas.getIdPaciente().getPersona().getApellidoM());
            citaDtos.setFecha(citas.getFecha());
            citaDtos.setHora(citas.getHora());
            citaDtos.setEstado(citas.getStatus());
            citaDto.add(citaDtos);
        }
        return citaDto;
    }


    public CitaDto findCitaById (Integer citaId){
        Optional<Cita> optionalCita = citaRepository.findById(citaId);
        if(optionalCita.isPresent()){
            Cita cita = optionalCita.get();
            CitaDto citaDto = new CitaDto();
            citaDto.setIdCita(cita.getIdCita());
            citaDto.setIdTipoCita(cita.getTipoCita().getIdTipoCita());
            citaDto.setIdHorario(cita.getHorario().getIdHorario());
            citaDto.setIdPaciente(cita.getIdPaciente().getIdPaciente());
            citaDto.setIdAsistente(cita.getIdAsistente());
            citaDto.setFecha(cita.getFecha());
            citaDto.setHora(cita.getHora());
            citaDto.setRazon(cita.getRazon());
            citaDto.setEstado(cita.getStatus());
            return citaDto;
        } else {
            throw new RuntimeException("La cita con ID " + citaId + " no existe");
        }
    }


    // Modificar la cita


    public void modificarCita(Integer citaId, CitaDto citaDto){
        Optional<Cita> optionalCita = citaRepository.findById(citaId);
        if(optionalCita.isPresent()){
            Cita cita = optionalCita.get();
            if (citaDto.getIdTipoCita() != null) {
                TipoCita tipoCita = new TipoCita();
                tipoCita.setIdTipoCita(citaDto.getIdTipoCita());
                cita.setTipoCita(tipoCita);
            }
            if (citaDto.getIdHorario() != null) {
                Horario horario = new Horario();
                horario.setIdHorario(citaDto.getIdHorario());
                cita.setHorario(horario);
            }
            cita.setIdAsistente(citaDto.getIdAsistente());
            cita.setFecha(citaDto.getFecha());
            cita.setHora(citaDto.getHora());
            cita.setRazon(citaDto.getRazon());
            cita.setStatus(citaDto.getEstado());
            citaRepository.save(cita);
        }else{
            throw new RuntimeException("La cita con ID "+ citaId + "no existe");
        }
    }
    // Boorado logico por cita
    public void borrarCita(Integer citaId){
        Optional<Cita> optionalCita = citaRepository.findById(citaId);
        if (optionalCita.isPresent()) {
            Cita cita = optionalCita.get();
            cita.setStatus(false);
            citaRepository.save(cita);
        }else{
            throw new RuntimeException("La cita con ID "+ citaId +" no existe");
        }
    }

    public List<CitaViewDto> findAllByStatusFalse(){
        List<Cita> citas = citaRepository.findAllByStatusFalse();
        List<CitaViewDto> citaDto = new ArrayList<>();
        for (Cita cita: citas) {
            CitaViewDto citaViewDto = new CitaViewDto();
            citaViewDto.setIdCita(cita.getIdCita());
            citaViewDto.setIdPaciente(cita.getIdPaciente().getIdPaciente());
            citaViewDto.setNombrePaciente(cita.getIdPaciente().getPersona().getNombre());
            citaViewDto.setApellidoPPaciente(cita.getIdPaciente().getPersona().getApellidoP());
            citaViewDto.setApellidoMPaciente(cita.getIdPaciente().getPersona().getApellidoM());
            citaViewDto.setFecha(cita.getFecha());
            citaViewDto.setHora(cita.getHora());
            citaViewDto.setEstado(cita.getStatus());
            citaDto.add(citaViewDto);
        }
        return citaDto;
    }
}
