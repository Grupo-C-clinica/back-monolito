package com.example.back_monolito.Dao;

import com.example.back_monolito.Entity.Historial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HistorialRepository extends JpaRepository<Historial, Integer> {
    //Obtener historiales dependiendo del paciente
    @Query("SELECT h FROM Historial h WHERE h.paciente.idPaciente =?1" )
    public List<Historial> obtenerHistorialPorIdPaciente(Integer idPaciente);

    @Query("SELECT h FROM  Historial h WHERE h.idHistorial =?1")
    public Historial obtenerHistorialById(Integer idHistorial);
}
