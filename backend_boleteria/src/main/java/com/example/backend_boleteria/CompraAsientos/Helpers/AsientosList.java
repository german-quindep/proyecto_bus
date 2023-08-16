package com.example.backend_boleteria.CompraAsientos.Helpers;

import java.util.ArrayList;
import java.util.List;

import com.example.backend_boleteria.CompraAsientos.Entity.CompraAsientoEntity;

public class AsientosList {
    List<Integer> asientosOcupados;

    public AsientosList() {
        this.asientosOcupados = new ArrayList<>();
    }

    // Returnamos el array ya obtenido del Resultado
    public List<Integer> getArrayAsiento(List<CompraAsientoEntity> comprarAsientos) {
        comprarAsientos.forEach(result -> {
            String asientosString = result.getAsiento_comprados();
            verifyMultiAsiento(asientosString);
        });
        return asientosOcupados;
    }

    // Esto permitira guardar en un array los asientos ocupados es decir
    // cliente1->1,2,3
    // cliente2->4
    // cliente1->6,7,8
    // result ->[1,2,3,4,6,7,8]
    private void verifyMultiAsiento(String asientosString) {
        if (asientosString.contains(",")) {
            String[] asientosArray = asientosString.split(",");
            for (String asiento : asientosArray) {
                this.asientosOcupados.add(Integer.parseInt(asiento.trim()));
            }
        } else {
            this.asientosOcupados.add(Integer.parseInt(asientosString));
        }
    }
}
