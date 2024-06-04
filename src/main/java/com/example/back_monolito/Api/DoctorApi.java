package com.example.back_monolito.Api;

import com.example.back_monolito.Bl.AsistenteBl;
import com.example.back_monolito.Bl.DoctorBl;
import com.example.back_monolito.Bl.PersonaBl;
import com.example.back_monolito.Dto.DoctorDto;
import com.example.back_monolito.Dto.PersonalRegisterDto;
import com.example.back_monolito.Dto.ResponseDto;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/doctor")
public class DoctorApi {
    @Autowired
    private DoctorBl doctorBl;
    @Autowired
    private PersonaBl personaBl;
    @Autowired
    private AsistenteBl asistenteBl;

    @PutMapping(path = "/{personal}/{idDoctor}")
    public ResponseEntity<ResponseDto<PersonalRegisterDto>> updateDoctor(@RequestBody PersonalRegisterDto doctorDto, @PathVariable Integer idDoctor, @PathVariable String personal){
        try{
            if (personal.equals("doctor")){
                doctorBl.updateDoctor(doctorDto, idDoctor);
                return ResponseEntity.ok(new ResponseDto<>(200, doctorDto, "Doctor modificado"));
            }else if (personal.equals("asistente")){
                asistenteBl.updateAsistente(doctorDto, idDoctor);
                return ResponseEntity.ok(new ResponseDto<>(200, doctorDto, "Asistente modificado"));
            }
            return ResponseEntity.ok(new ResponseDto<>(400, null, "Registration failed"));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.ok(new ResponseDto<>(500, null, "Error al modificar doctor"));
        }
    }
    @PutMapping(path = "/password")
    public ResponseEntity<ResponseDto<DoctorDto>> changePass(@RequestParam String username, @RequestParam String newPassword){
        try{
            doctorBl.changePasswordByUsername(username, newPassword);
            return ResponseEntity.ok(new ResponseDto<>(200, null, "Contraseña cambiada"));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.ok(new ResponseDto<>(500, null, "Error al cambiar contraseña"));
        }
    }

    @PutMapping(path = "/passId/{idDoctor}")
    public ResponseEntity<ResponseDto<DoctorDto>> changePassword(@PathVariable Integer idDoctor, @RequestParam String newPassword){
        try{
            doctorBl.changePassword(idDoctor, newPassword);
            return ResponseEntity.ok(new ResponseDto<>(200, null, "Contraseña cambiada"));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.ok(new ResponseDto<>(500, null, "Error al cambiar contraseña"));
        }
    }
    @PutMapping(path = "eliminado/{idDoctor}")
    public ResponseEntity<ResponseDto<DoctorDto>> eliminarDoctor(@PathVariable Integer idDoctor){
        try {
            doctorBl.eliminarDoctor(idDoctor);
            return ResponseEntity.ok(new ResponseDto<>(200, null, "el doctor se borro correctamente"));
        }catch (Exception e){
            return ResponseEntity.ok(new ResponseDto<>(500, null, "Error al borrar el doctor"));
        }
    }
}
