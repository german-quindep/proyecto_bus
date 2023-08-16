package com.example.backend_boleteria.Horario.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend_boleteria.Horario.DTO.In.ConsultHorario;
import com.example.backend_boleteria.Horario.Entity.HorarioEntity;
import com.example.backend_boleteria.Horario.Service.HorarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("${api.index}${api.horario.index}")
public class HorarioController {
    @Autowired
    private HorarioService horarioService;

    @PostMapping("${api.horario.create}")
    public ResponseEntity<?> createHorario(@RequestBody @Valid HorarioEntity horarioEntity) {
        return horarioService.createdHorario(horarioEntity);
    }

    @GetMapping("${api.horario.getall}")
    public ResponseEntity<?> getAllHorario() {
        return horarioService.getAllHorario();
    }

    @PostMapping("${api.horario.getAllBusHorario}")
    public ResponseEntity<?> getHorarioBus(@RequestBody @Valid ConsultHorario consultHorario) {
        return horarioService.getHorarioBus(consultHorario);
    }

    @GetMapping("${api.horario.getIdHorario}")
    public ResponseEntity<?> getHorarioOne(@PathVariable("id") String id){
        return horarioService.getHorarioOne(id);
    }
}
