package com.example.back_monolito.Api;

import com.example.back_monolito.Bl.AsistenteBl;
import com.example.back_monolito.Dto.DoctorDto;
import com.example.back_monolito.Dto.PersonalRegisterDto;
import com.example.back_monolito.Dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/asistente")
public class AsistenteApi {
    @Autowired
    private AsistenteBl asistenteBl;
    @PutMapping(path = "/{idAsistente}")
    public ResponseEntity<ResponseDto<PersonalRegisterDto>> updateDoctor(@RequestBody PersonalRegisterDto asistenteDto, @PathVariable Integer idAsistente){
        try{
            asistenteBl.updateAsistente(asistenteDto, idAsistente);
            return ResponseEntity.ok(new ResponseDto<>(200, asistenteDto, "Asistente modificado"));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.ok(new ResponseDto<>(500, null, "Error al modificar asistente"));
        }
    }
    @PutMapping(path = "/password")
    public ResponseEntity<ResponseDto<DoctorDto>> changePass(@RequestParam String username, @RequestParam String newPassword){
        try{
            asistenteBl.changePasswordByUsername(username, newPassword);
            return ResponseEntity.ok(new ResponseDto<>(200, null, "Contraseña cambiada"));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.ok(new ResponseDto<>(500, null, "Error al cambiar contraseña"));
        }
    }

    @PutMapping(path = "/passId/{idAsistente}")
    public ResponseEntity<ResponseDto<DoctorDto>> changePassword(@PathVariable Integer idAsistente, @RequestParam String newPassword){
        try{
            asistenteBl.changePassword(idAsistente, newPassword);
            return ResponseEntity.ok(new ResponseDto<>(200, null, "Contraseña cambiada"));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.ok(new ResponseDto<>(500, null, "Error al cambiar contraseña"));
        }
    }
    @PutMapping(path = "eliminado/{idAsistente}")
    public ResponseEntity<ResponseDto<DoctorDto>> eliminarDoctor(@PathVariable Integer idAsistente){
        try {
            asistenteBl.delateAsistente(idAsistente);
            return ResponseEntity.ok(new ResponseDto<>(200, null, "el asistente se borro correctamente"));
        }catch (Exception e){
            return ResponseEntity.ok(new ResponseDto<>(500, null, "Error al borrar asistente"));
        }
    }

}
