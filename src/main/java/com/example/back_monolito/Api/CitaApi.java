package com.example.back_monolito.Api;


import com.example.back_monolito.Bl.CitaBl;
import com.example.back_monolito.Dto.CitaDto;
import com.example.back_monolito.Dto.CitaViewDto;
import com.example.back_monolito.Dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/v1/cita")
//@CrossOrigin(origins = "*", methods= {org.springframework.web.bind.annotation.RequestMethod.GET, org.springframework.web.bind.annotation.RequestMethod.POST, org.springframework.web.bind.annotation.RequestMethod.PUT, org.springframework.web.bind.annotation.RequestMethod.DELETE})
public class CitaApi {

    @Autowired
    private CitaBl citaBl;

    //Crear cita para un paciente
    @PostMapping(path = "/create/{asistenteId}")
    public ResponseEntity<ResponseDto<CitaDto>> createCita(@PathVariable Integer asistenteId, @RequestBody CitaDto citaDto){
        citaBl.createCita(citaDto, asistenteId);
        try {
            return ResponseEntity.ok(new ResponseDto<>(200, citaDto, "Success"));
        } catch (Exception e){
            return ResponseEntity.ok(new ResponseDto<>(500, null, "Error"));
        }
    }

    //Ver todas las citas del paciente por su fecha
    @GetMapping(path = "/all/{pacienteId}/{fechaCita}")
    public ResponseEntity<ResponseDto<List<CitaDto>>> findAllByPatientIdAndDate(@PathVariable Integer pacienteId, @PathVariable Date fechaCita){
        List<CitaDto> citaDtos = citaBl.findAllByPatientIdAndDate(pacienteId, fechaCita);
        try {
            return ResponseEntity.ok(new ResponseDto<>(200, citaDtos, "Success"));
        } catch (Exception e){
            return ResponseEntity.ok(new ResponseDto<>(500, null, "Error"));
        }
    }

    @GetMapping(path = "/allDates/{fechaInicio}/{fechaFinal}")
    public ResponseEntity<ResponseDto<List<CitaDto>>> findAllByDateRange (@PathVariable Date fechaInicio, @PathVariable Date fechaFinal){
        List<CitaDto> citasDto = citaBl.findAllByDateRange(fechaInicio, fechaFinal);
        try {
            return ResponseEntity.ok(new ResponseDto<>(200, citasDto, "Succes"));
        }catch (Exception e){
            return ResponseEntity.ok(new ResponseDto<>(500, null, "Error"));
        }
    }

    @GetMapping("/all/{fecha}")
    public ResponseEntity<ResponseDto<List<CitaViewDto>>> findAllByDate(@PathVariable String fecha) {
        try {
            // Convertir el String a Date
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date fechaDate = formatter.parse(fecha);

            List<CitaViewDto> citaDto = citaBl.findAllByDate(fechaDate);
            return ResponseEntity.ok(new ResponseDto<>(200, citaDto, "Success"));
        } catch (ParseException e) {
            e.printStackTrace();
            return ResponseEntity.ok(new ResponseDto<>(500, null, "Error"));
        }
    }
    //Modificar la cita dependiendo su ID
    @PutMapping("/modificar/{citaId}")
    public ResponseEntity<ResponseDto<CitaDto>> modificarCita(@PathVariable Integer citaId, @RequestBody CitaDto citaDto){
        try{
            citaBl.modificarCita(citaId, citaDto);
            return ResponseEntity.ok(new ResponseDto<>(200, citaDto, "La cita se modifico correctamente"));
        }catch (Exception e){
            return ResponseEntity.ok(new ResponseDto<>(500, null, "Error al modificar la cita"));
        }
    }
    //Borrado logico de cita
    @PutMapping("/eliminado/{citaId}")
    public ResponseEntity<ResponseDto<CitaDto>> eliminarCita(@PathVariable Integer citaId){
        try {
            citaBl.borrarCita(citaId);
            return ResponseEntity.ok(new ResponseDto<>(200, null, "La cita se borro correctamente"));
        }catch (Exception e){
            return ResponseEntity.ok(new ResponseDto<>(500, null, "Error al borrar la cita"));
        }
    }

    @GetMapping("/{citaId}")
    public ResponseEntity<ResponseDto<CitaDto>> findCitaById(@PathVariable Integer citaId){
        try{
            CitaDto citaDto = citaBl.findCitaById(citaId);
            return ResponseEntity.ok(new ResponseDto<>(200, citaDto, "Success"));
        }catch (Exception e) {
            return ResponseEntity.ok(new ResponseDto<>(500, null, "Error"));
        }
    }

    @GetMapping("/status/false")
    public ResponseEntity<ResponseDto<List<CitaViewDto>>> findAllByStatusTrue(){
        try{
            List<CitaViewDto> citaDto = citaBl.findAllByStatusFalse();
            return ResponseEntity.ok(new ResponseDto<>(200, citaDto, "Success"));
        }catch (Exception e){
            return ResponseEntity.ok(new ResponseDto<>(500, null, "Error"));
        }
    }
}
