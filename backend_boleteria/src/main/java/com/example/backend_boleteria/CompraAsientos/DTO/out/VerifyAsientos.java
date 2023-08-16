package com.example.backend_boleteria.CompraAsientos.DTO.out;

import java.util.List;

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
public class VerifyAsientos {
    public List<Integer> asientosOcupados;
    public List<Integer> asientosDisponibles;
}
