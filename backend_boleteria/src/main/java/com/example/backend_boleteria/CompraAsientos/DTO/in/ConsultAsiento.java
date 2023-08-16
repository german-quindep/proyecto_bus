package com.example.backend_boleteria.CompraAsientos.DTO.in;

import org.hibernate.validator.constraints.UUID;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ConsultAsiento {
    @NotNull(message = "Este campo no debe estar vacio")
    @UUID(message = "Debe ser un id valido")
    public String horario_id;
}
