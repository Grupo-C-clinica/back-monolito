package com.example.back_monolito.Bl;


import com.example.back_monolito.Dao.PersonaRepository;
import com.example.back_monolito.Dto.PersonaDto;
import com.example.back_monolito.Entity.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
@Service
public class PersonaBl {
    @Autowired
    private PersonaRepository personaRepository;

    public Page<PersonaDto> findPeronasPacientes(Pageable pageable){
        Page<Persona> pagePersonas = personaRepository.findAllPacientes(pageable);
        return pagePersonas.map(persona -> new PersonaDto(persona.getIdPersona(), persona.getNombre(), persona.getApellidoP(),persona.getApellidoM(), persona.getFechaNacimiento(), persona.getGenero(), persona.getTelefono(), persona.getCi(), persona.getStatus()));
    }

    //Mostrar todos los pacientes ordenados por nombre de forma asecendente o descendente
    public Page<PersonaDto> findAllPacientesOrderByNombreAscOrDesc(Pageable pageable, Integer status){
        Page <Persona> pagePersonas;
        if (status == 1)
            pagePersonas = personaRepository.findAllPacientesOrderByNombreAsc(pageable);
        else
            pagePersonas = personaRepository.findAllPacientesOrderByNombreDesc(pageable);
        return pagePersonas.map(persona -> new PersonaDto(persona.getIdPersona(), persona.getNombre(), persona.getApellidoP(),persona.getApellidoM(), persona.getFechaNacimiento(), persona.getGenero(), persona.getTelefono(), persona.getCi(), persona.getStatus()));
    }


}
