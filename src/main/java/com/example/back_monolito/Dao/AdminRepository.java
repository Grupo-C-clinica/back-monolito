package com.example.back_monolito.Dao;

import com.example.back_monolito.Entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

    //Buscar admin por username y password
    @Query("SELECT a FROM Admin a WHERE a.username = ?1 AND a.password = ?2")
    Admin findAdminByUsernameAndPassword(String username, String password);
}
