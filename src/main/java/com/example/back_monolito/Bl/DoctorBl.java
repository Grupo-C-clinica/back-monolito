package com.example.back_monolito.Bl;

import com.example.back_monolito.Dao.DoctorRepository;
import com.example.back_monolito.Dao.PersonaRepository;
import com.example.back_monolito.Dto.DoctorDto;
import com.example.back_monolito.Entity.Doctor;
import com.example.back_monolito.Entity.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorBl {
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private PersonaRepository personaRepository;

    //Modificar un paciente
    public void updateDoctor(DoctorDto doctorDto, Integer idDoctor){
        try{
            Doctor doctor = doctorRepository.findById(idDoctor)
                    .orElseThrow(() -> new RuntimeException("Doctor no encontrado"));
            Persona persona = doctor.getPersona();
        } catch (Exception e){

        }
    }
}
