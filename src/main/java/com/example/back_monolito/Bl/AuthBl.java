package com.example.back_monolito.Bl;

import com.example.back_monolito.Dao.AdminRepository;
import com.example.back_monolito.Dao.AsistenteRepository;
import com.example.back_monolito.Dao.DoctorRepository;
import com.example.back_monolito.Dto.TokenDto;
import com.example.back_monolito.Entity.Admin;
import com.example.back_monolito.Entity.Asistente;
import com.example.back_monolito.Entity.Doctor;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AuthBl {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private AsistenteRepository asistenteRepository;

    @Autowired
    private AdminRepository adminRepository;

    private final String SECRET_KEY = "llave_xd";

    //Loguearse
    public TokenDto login(String username, String password) {
        Doctor doctor = doctorRepository.findDoctorByUsernameAndPassword(username, password);
        if (doctor != null) {
            String token = generateToken(doctor.getIdDoctor());
            return new TokenDto(token, doctor.getIdDoctor(), "doctor", doctor.getPersona().getNombre());
        }

        Asistente asistente = asistenteRepository.findAsistenteByUsernameAndPassword(username, password);
        if (asistente != null) {
            String token = generateToken(asistente.getIdAsistente());
            return new TokenDto(token, asistente.getIdAsistente(), "asistente", asistente.getPersona().getNombre());
        }

        Admin admin = adminRepository.findAdminByUsernameAndPassword(username, password);
        if (admin != null) {
            String token = generateToken(admin.getIdAdmin());
            return new TokenDto(token, admin.getIdAdmin(), "admin", admin.getPersona().getNombre());
        }

        throw new RuntimeException("Invalid credentials");
    }

    private String generateToken(Integer userId) {
        long currentTimeMillis = System.currentTimeMillis();
        return Jwts.builder()
                //.setSubject(String.valueOf(user.getUserId()))
                //.setSubject(String.valueOf(user.getRolId().getRolId()))
                .claim("userId", userId)
                .setIssuedAt(new Date(currentTimeMillis))
                .setExpiration(new Date(currentTimeMillis + 86400000)) // 1 hora de validez
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    public boolean validateToken(String token) {
        if (token != null && token.startsWith("Bearer ")) {
            token = token.substring(7);
        }

        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(SECRET_KEY)
                    .parseClaimsJws(token)
                    .getBody();

            return true;
        } catch (SignatureException e) {
            System.err.println("Token inválido: " + e.getMessage());
            return false;
        }
    }



}
