package com.example.back_monolito.Api;


import com.example.back_monolito.Bl.AsistenteBl;
import com.example.back_monolito.Bl.AuthBl;
import com.example.back_monolito.Bl.DoctorBl;
import com.example.back_monolito.Dto.LoginDto;
import com.example.back_monolito.Dto.ResponseDto;
import com.example.back_monolito.Dto.TokenDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    //@PostMapping("/register/")





}
