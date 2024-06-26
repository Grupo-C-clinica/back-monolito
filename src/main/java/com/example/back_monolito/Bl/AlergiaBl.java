package com.example.back_monolito.Bl;


import com.example.back_monolito.Dao.AlergiaRepository;
import com.example.back_monolito.Dto.AlergiaDto;
import com.example.back_monolito.Entity.Alergia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlergiaBl {
    @Autowired
    private AlergiaRepository alergiaRepository;

    //Mostrar alergias de un paciente
    public List<AlergiaDto> findAlergiasByPaciente(Integer idPaciente) {
        List<Alergia> alergias = alergiaRepository.findAlergiasByPaciente(idPaciente);
        List<AlergiaDto> alergiasDto = new ArrayList<>();
        for (Alergia alergia : alergias) {
            alergiasDto.add(new AlergiaDto(alergia.getIdAlergia(), alergia.getIdPaciente(), alergia.getTipoAlergia(), alergia.getCausa(), alergia.getStatus()));
        }
        return alergiasDto;
    }

    //Agregar alergia a un paciente
    public void addAlergiaByPaciente(List<AlergiaDto> alergias,Integer idPaciente) {
        for (AlergiaDto alergiaDto : alergias) {
            Alergia alergia = new Alergia();
            alergia.setIdPaciente(idPaciente);
            alergia.setTipoAlergia(alergiaDto.getTipoAlergia());
            alergia.setCausa(alergiaDto.getCausa());
            alergia.setStatus(true);
            alergiaRepository.save(alergia);
        }
    }

    //Eliminar alergia de un paciente
    public void deleteAlergiaByPaciente(Integer idAlergia) {
        Alergia alergia = new Alergia();
        alergia.setIdAlergia(idAlergia);
        alergia.setStatus(false);
        alergiaRepository.save(alergia);
    }

}
