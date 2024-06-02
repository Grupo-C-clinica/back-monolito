package com.example.back_monolito.Api;


import com.example.back_monolito.Bl.HorarioBl;
import com.example.back_monolito.Dto.HorarioDto;
import com.example.back_monolito.Dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/horario")
//@CrossOrigin(origins = "*", methods= {org.springframework.web.bind.annotation.RequestMethod.GET, org.springframework.web.bind.annotation.RequestMethod.POST, org.springframework.web.bind.annotation.RequestMethod.PUT, org.springframework.web.bind.annotation.RequestMethod.DELETE})
public class HorarioApi {

    @Autowired
    private HorarioBl horarioBl;

    //Mostrar todos los horarios disponibles
    @GetMapping("/all")
    public ResponseEntity<ResponseDto<Page<HorarioDto>>> findAllHorarios(@PageableDefault(page = 0, size = 10) Pageable pageable){
        Page<HorarioDto> horarioDtos = horarioBl.findAllHorarios(pageable);
        try {
            return ResponseEntity.ok(new ResponseDto<>(200, horarioDtos, "Success"));
        } catch (Exception e){
            return ResponseEntity.ok(new ResponseDto<>(500, null, "Error"));
        }

    }

    //Mostrar todos los horarios de un doctor
    @GetMapping("/all/doctor/{doctorId}")
    public ResponseEntity<ResponseDto<Page<HorarioDto>>> findAllHorariosByDoctorId(@PathVariable Integer doctorId, @PageableDefault(page = 0, size = 10) Pageable pageable){
        Page<HorarioDto> horarioDtos = horarioBl.findAllHorariosByDoctorId(doctorId, pageable);
        try {
            return ResponseEntity.ok(new ResponseDto<>(200, horarioDtos, "Success"));
        } catch (Exception e){
            return ResponseEntity.ok(new ResponseDto<>(500, null, "Error"));
        }
    }


    //Crear un horario de un doctor
    @PostMapping("/create/{doctorId}")
    public ResponseEntity<ResponseDto<String>> createHorario(@RequestBody HorarioDto horarioDto, @PathVariable Integer doctorId){
        horarioBl.createHorario(horarioDto, doctorId);
        try {
            return ResponseEntity.ok(new ResponseDto<>(200, "Horario creado correctamente", "Success"));
        } catch (Exception e){
            return ResponseEntity.ok(new ResponseDto<>(500, null, "Error"));
        }
    }



}
