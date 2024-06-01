package com.example.back_monolito.Bl;


import com.example.back_monolito.Dao.PacienteRepository;
import com.example.back_monolito.Dao.PersonaRepository;
import com.example.back_monolito.Dto.PacienteDto;
import com.example.back_monolito.Dto.PacienteViewDto;
import com.example.back_monolito.Entity.Paciente;
import com.example.back_monolito.Entity.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class PacienteBl {
    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private PersonaRepository personaRepository;

    //Agregar paciente
    public void addPaciente(PacienteDto nuevoPaciente)  {
        System.out.println("Paciente: " + nuevoPaciente);
        try {
            Persona persona = new Persona();
            persona.setNombre(nuevoPaciente.getNombre());
            persona.setApellidoP(nuevoPaciente.getApellidoP());
            persona.setApellidoM(nuevoPaciente.getApellidoM());
            persona.setFechaNacimiento(nuevoPaciente.getFechaNacimiento());
            persona.setGenero(nuevoPaciente.getGenero());
            persona.setTelefono(nuevoPaciente.getTelefono());
            persona.setCi(nuevoPaciente.getCi());
            persona.setStatus(true);
            personaRepository.save(persona);

            Paciente paciente = new Paciente();
            paciente.setPersona(persona);
            paciente.setIdZona(nuevoPaciente.getIdZona());
            paciente.setCorreo(nuevoPaciente.getCorreo());
            paciente.setTipoSangre(nuevoPaciente.getTipoSangre());
            paciente.setStatus(true);
            pacienteRepository.save(paciente);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Obtener lista de pacientes por nombre
    public List<PacienteViewDto> findPacientesByName(String nombre) {
        System.out.println("Nombre: " + nombre);
        nombre = nombre.toLowerCase();
        List<PacienteViewDto> pacientes = pacienteRepository.findPacienteViewDtosByNombreAndStatusTrue(nombre);
        return pacientes;
    }

    // Obtener lista de pacientes por fecha de nacimiento
    public List<PacienteViewDto> findPacientesByFecha(Date fechaNacimiento) {
        System.out.println("Fecha de nacimiento: " + fechaNacimiento);
        List<PacienteViewDto> pacientes = pacienteRepository.findPacienteViewDtosByFechaNacimientoAndStatusTrue(fechaNacimiento);
        return pacientes;
    }

    //Obtener lista de pacientes por estado
    public Page<PacienteViewDto> findPacientesByStatus(Boolean status, Pageable pageable) {
        System.out.println("Estado: " + status);
        return pacienteRepository.findPacienteViewDtosByStatus(status, pageable);
    }

    //Modificar un paciente
    public void updatePaciente(PacienteDto pacienteDto, Integer idPaciente) {
        System.out.println("Paciente: " + pacienteDto);
        try {
            Paciente paciente = pacienteRepository.findById(idPaciente)
                    .orElseThrow(() -> new RuntimeException("Paciente not found"));
            Persona persona = paciente.getPersona();

            persona.setNombre(pacienteDto.getNombre());
            persona.setApellidoP(pacienteDto.getApellidoP());
            persona.setApellidoM(pacienteDto.getApellidoM());
            persona.setFechaNacimiento(pacienteDto.getFechaNacimiento());
            persona.setGenero(pacienteDto.getGenero());
            persona.setTelefono(pacienteDto.getTelefono());
            persona.setCi(pacienteDto.getCi());
            persona.setStatus(true); // Aquí puedes establecer el status

            personaRepository.save(persona);

            paciente.setIdZona(pacienteDto.getIdZona());
            paciente.setCorreo(pacienteDto.getCorreo());
            paciente.setTipoSangre(pacienteDto.getTipoSangre());

            pacienteRepository.save(paciente);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
