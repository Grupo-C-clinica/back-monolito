package com.example.back_monolito.Bl;

import com.example.back_monolito.Dao.AsistenteRepository;
import com.example.back_monolito.Dao.PersonaRepository;
import com.example.back_monolito.Dto.AsistenteRegisterDto;
import com.example.back_monolito.Dto.PersonalRegisterDto;
import com.example.back_monolito.Entity.Asistente;
import com.example.back_monolito.Entity.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AsistenteBl {

    @Autowired
    private AsistenteRepository asistenteRepository;

    @Autowired
    private PersonaRepository personaRepository;

    //Registrar un asistente
    public void registerAsistente(PersonalRegisterDto personalRegisterDto){
        try{
            Persona persona = new Persona();
            persona.setNombre(personalRegisterDto.getNombre());
            persona.setApellidoP(personalRegisterDto.getApellidoP());
            persona.setApellidoM(personalRegisterDto.getApellidoM());
            persona.setFechaNacimiento(personalRegisterDto.getFechaNacimiento());
            persona.setCi(personalRegisterDto.getCi());
            persona.setTelefono(personalRegisterDto.getTelefono());
            persona.setGenero(personalRegisterDto.getGenero());
            personaRepository.save(persona);

            Asistente asistente = new Asistente();
            asistente.setPersona(persona);
            asistente.setCorreo(personalRegisterDto.getCorreo());
            asistente.setPassword(personalRegisterDto.getPassword());
            asistente.setUsername(personalRegisterDto.getUsername());
            asistente.setStatus(true);
            asistenteRepository.save(asistente);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateAsistente(PersonalRegisterDto personalRegisterDto, Integer idAsistente){
        try{
            Asistente asistente = asistenteRepository.findById(idAsistente)
                    .orElseThrow(() -> new RuntimeException("Asistente no encontrado"));
            Persona persona = asistente.getPersona();
            persona.setNombre(personalRegisterDto.getNombre());
            persona.setApellidoP(personalRegisterDto.getApellidoP());
            persona.setApellidoM(personalRegisterDto.getApellidoM());
            persona.setFechaNacimiento(personalRegisterDto.getFechaNacimiento());
            persona.setCi(personalRegisterDto.getCi());
            persona.setTelefono(personalRegisterDto.getTelefono());
            persona.setGenero(personalRegisterDto.getGenero());
            personaRepository.save(persona);

            asistente.setCorreo(personalRegisterDto.getCorreo());
            asistente.setPassword(personalRegisterDto.getPassword());
            asistente.setUsername(personalRegisterDto.getUsername());
            asistente.setStatus(true);
            asistenteRepository.save(asistente);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void changePassword (Integer idAsistente, String newPassword) {
        try {
            Asistente asistente = asistenteRepository.findById(idAsistente)
                    .orElseThrow(() -> new RuntimeException("Asistente no encontrado"));
            asistente.setPassword(newPassword);
            asistenteRepository.save(asistente);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void changePasswordByUsername(String username, String newPassword){
        try{
            Asistente asistente = asistenteRepository.findAsistenteByUsername(username)
                    .orElseThrow(() -> new RuntimeException("Asistente no encontrado"));
            asistente.setPassword(newPassword);
            asistenteRepository.save(asistente);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void delateAsistente(Integer idAsistente){
        try{
            Asistente asistente = asistenteRepository.findById(idAsistente)
                    .orElseThrow(() -> new RuntimeException("Asistente no Encontrado"));
            asistente.setStatus(false);
            asistenteRepository.save(asistente);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
