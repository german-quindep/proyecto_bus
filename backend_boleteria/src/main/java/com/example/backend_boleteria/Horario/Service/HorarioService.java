package com.example.backend_boleteria.Horario.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.backend_boleteria.Horario.DTO.In.ConsultHorario;
import com.example.backend_boleteria.Horario.DTO.Out.ConsultHorarioResponse;
import com.example.backend_boleteria.Horario.Entity.HorarioEntity;
import com.example.backend_boleteria.Horario.Repository.HorarioRepository;
import com.example.backend_boleteria.Shared.Messages.ResponseError;
import com.example.backend_boleteria.Shared.Response.Response;

@Service
public class HorarioService {

    @Autowired
    private HorarioRepository horarioRepository;

    public ResponseEntity<?> createdHorario(HorarioEntity horarioEntity) {
        Response<HorarioEntity, String> respo = new Response<>();
        HorarioEntity result = horarioRepository.save(horarioEntity);
        if (result != null)
            respo.ResponseSuccess("Se creo con exito el horario", 200, result);
        else
            respo.ResponseError(ResponseError.message.toString(), 404, ResponseError.save.toString());
        return ResponseEntity.status(respo.getStatus()).body(respo);
    }

    public ResponseEntity<?> getAllHorario() {
        Response<List<HorarioEntity>, String> respo = new Response<>();
        List<HorarioEntity> listHorario = horarioRepository.findAll();
        if (listHorario.isEmpty())
            respo.ResponseError(ResponseError.message.toString(), 404, ResponseError.list.toString());
        else
            respo.ResponseSuccess("Se consulta con exito", 200, listHorario);
        return ResponseEntity.status(respo.getStatus()).body(respo);
    }

    public ResponseEntity<?> getHorarioBus(ConsultHorario consult) {
        Response<List<ConsultHorarioResponse>, String> respo = new Response<>();
        List<ConsultHorarioResponse> listHorario = horarioRepository.getResultHorarios(consult);
        if (listHorario.isEmpty())
            respo.ResponseError(ResponseError.message.toString(), 404, ResponseError.filtro.toString());
        else
            respo.ResponseSuccess("Se filtra con exito", 200, listHorario);
        return ResponseEntity.status(respo.getStatus()).body(respo);
    }

    public ResponseEntity<?> getHorarioOne(String id_horario) {
        Response<HorarioEntity, String> respo = new Response<>();
        HorarioEntity entityHorario = horarioRepository.getOneHorarioEntity(id_horario);
        if (entityHorario != null)
            respo.ResponseSuccess("Se filtra con exito", 200, entityHorario);
        else
            respo.ResponseError(ResponseError.message.toString(), 404, ResponseError.filtro.toString());
        return ResponseEntity.status(respo.getStatus()).body(respo);
    }

    public HorarioEntity getHorarioServiceOne(String id_horario) {
        return horarioRepository.getOneHorarioEntity(id_horario);
    }
}
