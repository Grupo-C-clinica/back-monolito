package com.example.back_monolito.Dao;

import com.example.back_monolito.Entity.Asistente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AsistenteRepository extends JpaRepository<Asistente, Integer> {

    //Buscar asistente por username y password
    @Query("SELECT a FROM Asistente a WHERE a.username = ?1 AND a.password = ?2")
    Asistente findAsistenteByUsernameAndPassword(String username, String password);
}
