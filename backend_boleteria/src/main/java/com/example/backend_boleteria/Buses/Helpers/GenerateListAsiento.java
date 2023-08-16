package com.example.backend_boleteria.Buses.Helpers;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class GenerateListAsiento {
    public List<Integer> asientosTotal;

    public List<Integer> generateList(Integer asientos) {
        this.asientosTotal = new ArrayList<>();
        for (int i = 1; i <= asientos; i++) {
            this.asientosTotal.add(i);
        }
        return this.asientosTotal;
    }
}
