package com.example.backend_boleteria.Buses.DTO.out;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class BusList {
    public String id;

    public String marca;

    public Integer asientos;

    public List<Integer> asientosTotal;
}
