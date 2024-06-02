package com.example.back_monolito.Dao;

import com.example.back_monolito.Entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

    //Buscar doctor por username y password
    @Query("SELECT d FROM Doctor d WHERE d.username = ?1 AND d.password = ?2")
    Doctor findDoctorByUsernameAndPassword(String username, String password);

}
