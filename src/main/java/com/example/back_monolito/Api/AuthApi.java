package com.example.back_monolito.Api;


import com.example.back_monolito.Bl.AsistenteBl;
import com.example.back_monolito.Bl.AuthBl;
import com.example.back_monolito.Bl.DoctorBl;
import com.example.back_monolito.Dto.PersonalRegisterDto;
import com.example.back_monolito.Dto.LoginDto;
import com.example.back_monolito.Dto.ResponseDto;
import com.example.back_monolito.Dto.TokenDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthApi {

    @Autowired
    private AuthBl authBl;

    @Autowired
    private DoctorBl doctorBl;

    @Autowired
    private AsistenteBl asistenteBl;

    //Login
    @PostMapping("/login")
    public ResponseEntity<ResponseDto<TokenDto>> loginUser(@RequestBody LoginDto loginDto) {
        try {
            TokenDto token = authBl.login(loginDto.getUsuario(), loginDto.getContrasena());
            return ResponseEntity.ok(new ResponseDto<>(200, token, "Login successful"));
        } catch (RuntimeException e) {
            return ResponseEntity.ok(new ResponseDto<>(400, null, "Invalid credentials"));
        }
    }

    //crear usuario
    @PostMapping("/register/{usuario}")
    public ResponseEntity<ResponseDto<PersonalRegisterDto>> registerUser(@PathVariable String usuario , @RequestBody PersonalRegisterDto personalRegisterDto) {
        try {
            if (usuario.equals("doctor")) {
                doctorBl.registerDoctor(personalRegisterDto);
                return ResponseEntity.ok(new ResponseDto<>(200, null, "Doctor registered successfully"));
            } else if (usuario.equals("asistente")) {
                asistenteBl.registerAsistente(personalRegisterDto);
                return ResponseEntity.ok(new ResponseDto<>(200, null, "Asistente registered successfully"));
            }
            return ResponseEntity.ok(new ResponseDto<>(400, null, "Registration failed"));
        } catch (RuntimeException e) {
            return ResponseEntity.ok(new ResponseDto<>(400, null, "Registration failed"));
        }
    }





}
