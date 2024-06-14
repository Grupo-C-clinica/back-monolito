package com.example.back_monolito.Bl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SuscripcionBl {

    @Autowired EmailSenderBl emailSenderBl;

    //Suscribirse
    public void suscribirse(String email){
        emailSenderBl.sendEmail(email, "Gracias por suscribirte", "Gracias por suscribirte a nuestro boletin de noticias y promociones de nuestra clinica");
    }

}
