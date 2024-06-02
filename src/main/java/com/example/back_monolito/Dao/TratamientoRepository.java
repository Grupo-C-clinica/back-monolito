package com.example.back_monolito.Dao;

import com.example.back_monolito.Entity.Tratamiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TratamientoRepository extends JpaRepository<Tratamiento, Integer> {
    //Obtener tratamientos por historiales
    @Query("SELECT t FROM Tratamiento t WHERE t.historial.idHistorial =?1")
    public List<Tratamiento> obtenerTratamientoPorIdHistorial(Integer idHistorial);

    //Obtener Tratamiento por Id
    @Query("SELECT t FROM Tratamiento t WHERE t.idTratamiento=?1")
    public Tratamiento obtenerTratamientoById(Integer idTratamiento);
}
