package com.example.backend_boleteria.Buses.Helpers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.backend_boleteria.Buses.DTO.out.BusList;
import com.example.backend_boleteria.Buses.Entity.BusEntity;

@Component
public class TransformResponse {
    public List<BusList> getAllBus;

    // Transformar el response data de otra entidad para retornar una lista de buses
    public List<BusList> getDataAllBus(List<BusEntity> listBus) {
        this.getAllBus = new ArrayList<>();
        listBus.forEach(res -> {
            BusList modelList = new BusList(res.getId(), res.getMarca(), res.getAsientos(), res.getAsientosTotal());
            this.getAllBus.add(modelList);
        });
        return this.getAllBus;
    }
}
