package com.example.backend_boleteria.CompraAsientos.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend_boleteria.CompraAsientos.DTO.in.ConsultAsiento;
import com.example.backend_boleteria.CompraAsientos.Entity.CompraAsientoEntity;
import com.example.backend_boleteria.CompraAsientos.Service.ComprarAsientosService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("${api.index}${api.asientos.index}")
public class ComprarAsientosController {

    @Autowired
    private ComprarAsientosService compraAsientosService;

    @PostMapping("${api.asientos.create}")
    public ResponseEntity<?> created(@RequestBody @Valid CompraAsientoEntity compraAsientoEntity) {
        return compraAsientosService.createdBus(compraAsientoEntity);
    }

    @PostMapping("${api.asientos.getAll}")
    public ResponseEntity<?> getAsientosDisponible(@RequestBody @Valid ConsultAsiento consultaAsiento) {
        return compraAsientosService.getListAsiento(consultaAsiento);
    }

}
