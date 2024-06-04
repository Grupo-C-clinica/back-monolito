package com.example.back_monolito.Bl;

import com.example.back_monolito.Dao.DoctorRepository;
import com.example.back_monolito.Dao.PersonaRepository;
import com.example.back_monolito.Dto.DoctorDto;
import com.example.back_monolito.Dto.PersonalRegisterDto;
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


    //Registrar un doctor
    public void registerDoctor(PersonalRegisterDto doctorRegisterDto){
        try{
            Persona persona = new Persona();
            persona.setNombre(doctorRegisterDto.getNombre());
            persona.setApellidoP(doctorRegisterDto.getApellidoP());
            persona.setApellidoM(doctorRegisterDto.getApellidoM());
            persona.setFechaNacimiento(doctorRegisterDto.getFechaNacimiento());
            persona.setCi(doctorRegisterDto.getCi());
            persona.setTelefono(doctorRegisterDto.getTelefono());
            persona.setGenero(doctorRegisterDto.getGenero());
            personaRepository.save(persona);

            Doctor doctor = new Doctor();
            doctor.setPersona(persona);
            doctor.setCorreo(doctorRegisterDto.getCorreo());
            doctor.setPassword(doctorRegisterDto.getPassword());
            doctor.setUsername(doctorRegisterDto.getUsername());
            doctor.setStatus(true);
            doctorRepository.save(doctor);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
