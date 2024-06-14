package com.example.back_monolito.Api;

import com.example.back_monolito.Bl.SuscripcionBl;
import com.example.back_monolito.Dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/suscripcion")
public class SuscripcionApi {

    @Autowired
    private SuscripcionBl suscripcionBl;

    //Suscribirse
    @GetMapping (path = "/{email}")
    public ResponseEntity<ResponseDto<String>> suscribirse(String email){
        try{
            suscripcionBl.suscribirse(email);
            return ResponseEntity.ok(new ResponseDto<>(200, email, "Gracias por suscribirte"));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.ok(new ResponseDto<>(500, null, "Error al suscribirte"));
        }
    }

}
