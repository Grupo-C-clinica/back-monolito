package com.example.back_monolito.Bl;

import com.example.back_monolito.Dao.AsistenteRepository;
import com.example.back_monolito.Dao.DoctorRepository;
import com.example.back_monolito.Dto.PersonalRegisterDto;
import com.example.back_monolito.Dto.UsuarioViewDto;
import com.example.back_monolito.Entity.Asistente;
import com.example.back_monolito.Entity.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioBl {
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private AsistenteRepository asistenteRepository;

    public List<UsuarioViewDto> obtenerTodosLosUsuarios(){
        List<UsuarioViewDto> usuarios = new ArrayList<>();

        //Obtener los doctores
        List<Doctor> doctores = doctorRepository.findAll();
        for(Doctor doctor: doctores){
            UsuarioViewDto dto = new UsuarioViewDto();
            dto.setNombre(doctor.getPersona().getNombre());
            dto.setApellidoP(doctor.getPersona().getApellidoP());
            dto.setApellidoM(doctor.getPersona().getApellidoM());
            dto.setTelefono(doctor.getPersona().getTelefono());
            dto.setCorreo(doctor.getCorreo());
            dto.setUsername(doctor.getUsername());
            usuarios.add(dto);
        }

        //Obtener todos los asistentes
        List<Asistente> asistentes = asistenteRepository.findAll();
        for(Asistente asistente : asistentes){
            UsuarioViewDto dto = new UsuarioViewDto();
            dto.setNombre(asistente.getPersona().getNombre());
            dto.setApellidoP(asistente.getPersona().getApellidoP());
            dto.setApellidoM(asistente.getPersona().getApellidoM());
            dto.setTelefono(asistente.getPersona().getTelefono());
            dto.setCorreo(asistente.getCorreo());
            dto.setUsername(asistente.getUsername());
            usuarios.add(dto);
        }
        return usuarios;
    }
}
