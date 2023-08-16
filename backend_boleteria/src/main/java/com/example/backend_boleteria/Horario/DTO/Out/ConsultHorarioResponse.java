package com.example.backend_boleteria.Horario.DTO.Out;

import java.time.LocalDateTime;
import java.util.UUID;

public interface ConsultHorarioResponse {
    UUID getId();

    LocalDateTime getHorarioLlegada();

    LocalDateTime getHorarioSalida();

    String getMarcaBus();

    String getDestinoLlegada();

    String getDestinoSalida();

    UUID getIdBus();

}
