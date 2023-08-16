package com.example.backend_boleteria.Horario.DTO.In;

import java.sql.Date;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ConsultHorario {
    @NotNull(message = "No debe estar vacio")
    private Date fechaHoy;
}
