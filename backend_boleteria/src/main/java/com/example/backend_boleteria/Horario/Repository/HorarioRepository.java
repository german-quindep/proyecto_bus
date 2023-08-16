package com.example.backend_boleteria.Horario.Repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.backend_boleteria.Horario.DTO.In.ConsultHorario;
import com.example.backend_boleteria.Horario.DTO.Out.ConsultHorarioResponse;
import com.example.backend_boleteria.Horario.Entity.HorarioEntity;
import com.example.backend_boleteria.Horario.Query.QueryHorario;

public interface HorarioRepository extends JpaRepository<HorarioEntity, UUID> {
    @Query(value = QueryHorario.GET_HORARIO_DATE, nativeQuery = true)
    List<ConsultHorarioResponse> getResultHorarios(@Param("consult") ConsultHorario consult);

    @Query(value=QueryHorario.GET_HORARIO_ONE, nativeQuery = true)
    HorarioEntity getOneHorarioEntity(@Param("idHorario") String idHorario);
}
